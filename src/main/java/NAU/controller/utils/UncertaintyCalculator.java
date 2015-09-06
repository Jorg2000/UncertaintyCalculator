package NAU.controller.utils;

import java.math.BigDecimal;


import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

/**
 * Created by root on 05.09.2015.
 */
public class UncertaintyCalculator {
    MathContext mathContext;
    public UncertaintyCalculator() {
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
        }
        else {
            return 0;
        }
    }

    public double repeatabilityLimit(double stanDev) {
        return 2.77 * stanDev;
    }


}
