package NAU.controller.utils;

import java.math.BigDecimal;


import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;


public class MathUtils {
    private MathContext mathContext;

    public MathUtils() {
        mathContext = new MathContext(4, RoundingMode.HALF_UP);
    }

    public double amplitude(double w1, double w2) {
        return Math.abs(w1 - w2);
    }

    public double mean(List<Double> arr) {
        BigDecimal sum = new BigDecimal(0);
        for (Double a : arr) {
            sum = sum.add(new BigDecimal(a));
        }

        return sum.divide(new BigDecimal(arr.size()), mathContext).doubleValue();
    }

    public double stanDevByConst(double mean) {

        return mean * 0.886;

    }

    public double stanDev(List<Double> arr) {
        if (arr.size() > 1) {

            BigDecimal mean = new BigDecimal(mean(arr));

            BigDecimal sum = new BigDecimal(0);
            for (Double a : arr) {
                BigDecimal ai = new BigDecimal(a);
                BigDecimal curSub = mean.subtract(ai);
                BigDecimal curPower = curSub.pow(2);
                sum = sum.add(curPower);
            }
            BigDecimal underRoot = sum.divide(new BigDecimal(arr.size()).subtract(new BigDecimal(1)), mathContext);
            return Math.sqrt(underRoot.round(mathContext).doubleValue());
        } else {
            return 0;
        }
    }

    public double repeatabilityLimit(double stanDev) {
        return 2.77 * stanDev;
    }

    /*Calculation of crushability*/
    public double crushability(double sampleMass, double remainedMass) {

        if (sampleMass != 0 & remainedMass != 0) {
            MathContext localMathContext = new MathContext(3, RoundingMode.HALF_UP);
            BigDecimal sampleMassBD = new BigDecimal(sampleMass);
            BigDecimal remainedMassBD = new BigDecimal(remainedMass);
            BigDecimal sub = sampleMassBD.subtract(remainedMassBD, localMathContext);
            BigDecimal mul = sub.multiply(new BigDecimal(100.0), localMathContext);
            BigDecimal diff = mul.divide(remainedMassBD, localMathContext);
            return diff.doubleValue();
        }
        return 0.0;
    }

    /*Coefficient of the influence for remain weighting (cm1)*/
    public double influenceCoeffCM1(double amount) {
        if (amount != 0) {
            BigDecimal am = new BigDecimal(amount);
            BigDecimal res = new BigDecimal(100).divide(am, mathContext);
            return res.round(mathContext).doubleValue();
        } else
            return 0;
    }

    /*Calculation of uncertainty of the constant mass */
    public double constMassUncertainty(double mass) {
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
    public double uncertaintyWithInfluenceCoeff(double uncertainty, double influenceCoeff) {
        if (uncertainty != 0 & influenceCoeff != 0) {
            BigDecimal res = new BigDecimal(uncertainty).multiply(new BigDecimal(influenceCoeff));
            return res.round(mathContext).doubleValue();
        } else {
            return 0;
        }
    }

    /*Calculation of influence coefficient for sample weighting (cm)*/
    public double influenceCoeffUM(double sampleMeanMass, double remainMeanMass) {
         if (sampleMeanMass != 0 & remainMeanMass != 0)  {
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
    public double roundnessUncertainty(double roundness) {
        if (roundness != 0 & roundness >= 0) {
            BigDecimal round = new BigDecimal(roundness);
            BigDecimal res = round.divide(new BigDecimal(2).multiply(new BigDecimal(Math.sqrt(3))), mathContext);
            return res.round(mathContext).doubleValue();
        } else {
            return 0;
        }
    }

    /*Calculation of the convergence*/
    public double convergence(double maxDiffBetweenResults) {
        if (maxDiffBetweenResults != 0) {
            BigDecimal maxDiff = new BigDecimal(maxDiffBetweenResults);
            BigDecimal res = maxDiff.divide(new BigDecimal(2.77), mathContext);
            return res.round(mathContext).doubleValue();
        } else {
            return 0;
        }
    }

    /*Calculation of total standard uncertainty */
    public double totalStandardUncertainty(double stdUncertaintyUM1,
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

            double res =    Math.sqrt(Math.pow(stdUncertaintyUM1 * influenceCoeffCM1,2) +
                            Math.pow(stdUncertaintyUM * influenceCoeffCM,2) +
                            Math.pow(roundnessUncertainty,2) +
                            Math.pow(convergence,2) / 2);

            BigDecimal bdRes = new BigDecimal(res);
            return bdRes.round(mathContext).doubleValue();
        }
        return 0;
    }

    /*Calculation of extended uncertainty*/
    public double extendedUncertainty(double uncertainty){
        if (uncertainty !=0){

            BigDecimal res = new BigDecimal(uncertainty * 2);
            return res.round(mathContext).doubleValue();
        }
        return 0;
    }

}

