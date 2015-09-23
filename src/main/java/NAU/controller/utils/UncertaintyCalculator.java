package NAU.controller.utils;

import NAU.model.POJO.UncertaintyDataContainer;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by SUSLOV on 15.09.2015.
 */
public class UncertaintyCalculator {

    private UncertaintyDataContainer dataContainer;
    private MathContext mathContext;
    private double influenceCoefCM1;
    private double influenceCoefCM1CxUx;
    private double constMassUncertainty;
    private double influenceCoefCM;
    private double influenceCoefCMCxUx;
    private double roundness;
    private double roundnessUncertainty;
    private double roundnessUncertaintyCxUx;
    private double convergence;
    private double convergenceCxUx;
    private double totalStandUncertainty;
    private double extendedUncertainty;



    public UncertaintyCalculator(UncertaintyDataContainer dataContainer) {
        this.dataContainer = dataContainer;
        mathContext = new MathContext(4, RoundingMode.HALF_UP);
        roundness = 1;
        recalculate();
    }

    public void setDataContainer(UncertaintyDataContainer dataContainer) {
        recalculateUncertainty(dataContainer);
    }

    public void recalculateUncertainty(UncertaintyDataContainer dataContainer) {
        this.dataContainer = dataContainer;
        recalculate();
    }


    private void recalculate() {
        influenceCoefCM1 = calcInfluenceCoeffCM1(dataContainer.getMeanRemainMass());
        influenceCoefCM1CxUx = calcUncertaintyWithInfluenceCoeff(dataContainer.getStanMassWeightingUncertainty(), influenceCoefCM1);
        constMassUncertainty = calcConstMassUncertainty(dataContainer.getMeanRemainMass());
        influenceCoefCM = calcInfluenceCoeffCM(dataContainer.getMeanSampleMass(), dataContainer.getMeanRemainMass());
        influenceCoefCMCxUx = calcUncertaintyWithInfluenceCoeff(dataContainer.getStanMassWeightingUncertainty(), influenceCoefCM);
        roundnessUncertainty = calcRoundnessUncertainty(roundness);
        roundnessUncertaintyCxUx = calcUncertaintyWithInfluenceCoeff(roundnessUncertainty, 1);
        convergence = calcConvergence(dataContainer.getMaxDifferenceBetweenResults());
        convergenceCxUx = calcUncertaintyWithInfluenceCoeff(convergence,1);
        totalStandUncertainty = calcTotalStandardUncertainty(dataContainer.getStanMassWeightingUncertainty(),
                influenceCoefCM1,
                dataContainer.getStanMassWeightingUncertainty(),
                influenceCoefCM,
                roundnessUncertainty, convergence);
        extendedUncertainty = calcExtendedUncertainty(totalStandUncertainty);
    }

    /*Coefficient of the influence for remain weighting (cm1)*/
    private double calcInfluenceCoeffCM1(double amount) {
        if (amount != 0) {
            BigDecimal am = new BigDecimal(amount);
            BigDecimal res = new BigDecimal(100).divide(am, mathContext);
            return res.round(mathContext).doubleValue();
        } else
            return 0;
    }

    /*Calculation of uncertainty of the constant mass */
    private double calcConstMassUncertainty(double mass) {
        if (mass != 0) {
            BigDecimal m = new BigDecimal(mass);
            BigDecimal res = m.multiply(new BigDecimal(0.1)).
                    divide(new BigDecimal(2).multiply(new BigDecimal(Math.sqrt(3))), mathContext);
            return res.round(mathContext).doubleValue();
        } else {
            return 0;
        }
    }

    /*Calculation of adding uncertainty to influence Coefficient*/
    private double calcUncertaintyWithInfluenceCoeff(double uncertainty, double influenceCoeff) {
        if (uncertainty != 0 & influenceCoeff != 0) {
            BigDecimal res = new BigDecimal(uncertainty).multiply(new BigDecimal(influenceCoeff));
            return res.round(mathContext).doubleValue();
        } else {
            return 0;
        }
    }

    /*Calculation of influence coefficient for sample weighting (cm)*/
    private double calcInfluenceCoeffCM(double sampleMeanMass, double remainMeanMass) {
        if (sampleMeanMass != 0 & remainMeanMass != 0) {
            BigDecimal smm = new BigDecimal(sampleMeanMass);
            BigDecimal rmm = new BigDecimal(remainMeanMass);
            BigDecimal numerator = new BigDecimal(100).multiply(smm);
            BigDecimal denominator = rmm.pow(2);
            BigDecimal res = numerator.divide(denominator, mathContext);
            return res.round(mathContext).doubleValue();
        } else
            return 0;
    }

    /*Calculation of the roundness uncertainty*/
    private double calcRoundnessUncertainty(double roundness) {
        if (roundness != 0 & roundness >= 0) {
            BigDecimal round = new BigDecimal(roundness);
            BigDecimal res = round.divide(new BigDecimal(2).multiply(new BigDecimal(Math.sqrt(3))), mathContext);
            return res.round(mathContext).doubleValue();
        } else {
            return 0;
        }
    }

    /*Calculation of the convergence*/
    private double calcConvergence(double maxDiffBetweenResults) {
        if (maxDiffBetweenResults != 0) {
            BigDecimal maxDiff = new BigDecimal(maxDiffBetweenResults);
            BigDecimal res = maxDiff.divide(new BigDecimal(2.77), mathContext);
            return res.round(mathContext).doubleValue();
        } else {
            return 0;
        }
    }

    /*Calculation of total standard uncertainty */
    private double calcTotalStandardUncertainty(double stdUncertaintyUM1,
                                               double influenceCoeffCM1,
                                               double stdUncertaintyUM,
                                               double influenceCoeffCM,
                                               double roundnessUncertainty,
                                               double convergence) {

        if (stdUncertaintyUM1 != 0 &
                influenceCoeffCM1 != 0 &
                stdUncertaintyUM != 0 &
                influenceCoeffCM != 0 &
                roundnessUncertainty != 0 &
                convergence != 0) {

            double res = Math.sqrt(Math.pow(stdUncertaintyUM1 * influenceCoeffCM1, 2) +
                    Math.pow(stdUncertaintyUM * influenceCoeffCM, 2) +
                    Math.pow(roundnessUncertainty, 2) +
                    Math.pow(convergence, 2) / 2);

            BigDecimal bdRes = new BigDecimal(res);
            return bdRes.round(mathContext).doubleValue();
        }
        return 0;
    }

    /*Calculation of extended uncertainty*/
    private double calcExtendedUncertainty(double uncertainty) {
        if (uncertainty != 0) {

            BigDecimal res = new BigDecimal(uncertainty * 2);
            return res.round(mathContext).doubleValue();
        }
        return 0;
    }

    public double getInfluenceCoefCM1() {
        return influenceCoefCM1;
    }

    public double getInfluenceCoefCM1CxUx() {
        return influenceCoefCM1CxUx;
    }

    public double getConstMassUncertainty() {
        return constMassUncertainty;
    }

    public double getInfluenceCoefCM() {
        return influenceCoefCM;
    }

    public double getInfluenceCoefCMCxUx() {
        return influenceCoefCMCxUx;
    }

    public double getRoundnessUncertainty() {
        return roundnessUncertainty;
    }

    public double getConvergence() {
        return convergence;
    }

    public double getTotalStandUncertainty() {
        return totalStandUncertainty;
    }

    public double getExtendedUncertainty() {
        return extendedUncertainty;
    }

    public double getRoundness() {
        return roundness;
    }

    public double getStandardMassWeightUncertainty() {
        return this.dataContainer.getStanMassWeightingUncertainty();
    }

    public double getRoundnessUncertaintyCxUx() {
        return roundnessUncertaintyCxUx;
    }

    public double getConvergenceCxUx() {
        return convergenceCxUx;
    }
}
