package NAU.controller.utils;

import java.math.BigDecimal;


import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;


public class UncertaintyCalculator {
    private MathContext mathContext;

    public UncertaintyCalculator() {
        mathContext = new MathContext(4, RoundingMode.HALF_UP);
    }

    public double amplitude(double w1, double w2) {
        return Math.abs(w1 - w2);
    }

    public double mean(List<Double> arr) {
        BigDecimal sum = new BigDecimal(0);
        for (Double a : arr) {
            sum = sum.add(new BigDecimal(a),mathContext);
        }

        return sum.divide(new BigDecimal(arr.size(), mathContext)).doubleValue();
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
}
