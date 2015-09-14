package NAU.controller.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedList;

public  class UncertaintyCalculatorTest extends Assert {

        private LinkedList<Double> data;
        private DecimalFormat df;


    @Before
        public  void setUpData() {
            data = new LinkedList<Double>();
            data.add(0.58);data.add(5.09);data.add(0.83);data.add(1.16);data.add(3.63);
            data.add(5.29);data.add(2.37);data.add(4.03);data.add(3.25);data.add(0.52);
            data.add(1.91);data.add(0.25);data.add(6.84);data.add(0.55);data.add(4.95);
            data.add(0.74);data.add(3.96);data.add(1.89);data.add(1.92);data.add(6.25);
            df = new DecimalFormat("0.00");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            df.setRoundingMode(RoundingMode.HALF_UP);
            df.setDecimalFormatSymbols(decimalFormatSymbols);
        }

        @Test
        public void testMeanAmplitude() throws Exception {
            UncertaintyCalculator mc = new UncertaintyCalculator();
            double actual = mc.mean(data);
            double expected = 2.80;
            assertEquals(df.format(expected), df.format(actual));
        }

        @Test
        public void testStanDevByConst() throws Exception {
            UncertaintyCalculator mc = new UncertaintyCalculator();
            double actual = mc.stanDevByConst(mc.mean(data));
            double expected = 2.48;
            assertEquals(df.format(expected), df.format(actual));
        }

        @Test
        public void testRepeatabilityLimit() throws Exception {
            UncertaintyCalculator mc = new UncertaintyCalculator();
            double actual = mc.repeatabilityLimit(mc.stanDevByConst(mc.mean(data)));
            double expected = 6.87;
            assertEquals(df.format(expected), df.format(actual));

        }

        @Test
        public void testStanDev() throws Exception {
            UncertaintyCalculator mc = new UncertaintyCalculator();
            double actual = mc.stanDev(data);
            double expected = 2.09;
            assertEquals(df.format(expected), df.format(actual));
        }

    @Test
    public void testCrushabilityA() throws Exception {

        DecimalFormat localDF = new DecimalFormat("0.0");
        UncertaintyCalculator mc = new UncertaintyCalculator();
        double sampleMass = 1344.2;
        double remainMass = 1324.2;
        double actual = mc.crushability(sampleMass, remainMass);
        double expected = 1.5;
        assertEquals(localDF.format(expected), localDF.format(actual));

    }

    @Test
    public void testCrushabilityB() throws Exception {

        DecimalFormat localDF = new DecimalFormat("0.0");
        UncertaintyCalculator mc = new UncertaintyCalculator();
        double sampleMass = 1330.1;
        double remainMass = 1319.1;
        double actual = mc.crushability(sampleMass,remainMass);
        double expected = 0.8;
        assertEquals(localDF.format(expected), localDF.format(actual));

    }


    @Test
    public void testInfluenceCoeff() throws Exception {
        DecimalFormat localDF = new DecimalFormat("0.00");
        UncertaintyCalculator mc = new UncertaintyCalculator();
        double amount = 1321.7;
        double actual = mc.influenceCoeff(amount);
        double expected = 0.08;
        assertEquals(localDF.format(expected), localDF.format(actual));
    }

    @Test
    public void testConstMassUncertaintyA() throws Exception {

        UncertaintyCalculator mc = new UncertaintyCalculator();
        double mass = 1321.7;
        double actual = mc.constMassUncertainty(mass);
        double expected = 38.15;
        assertEquals(df.format(expected), df.format(actual));
    }

    @Test
    public void testConstMassUncertaintyB() throws Exception {

        UncertaintyCalculator mc = new UncertaintyCalculator();
        double mass = 1319.7;
        double actual = mc.constMassUncertainty(mass);
        double expected = 38.10;
        assertEquals(df.format(expected), df.format(actual));
    }


    @Test
    public void testInfluenceCoeffUxCx() throws Exception {
        UncertaintyCalculator mc = new UncertaintyCalculator();
        DecimalFormat localDF = new DecimalFormat("0.0");
        double stdUncertainty = 1.00;
        double influenceCoeff = 0.08;
        double actual = mc.influenceCoeffUxCx(stdUncertainty,influenceCoeff);
        double expected = 0.1;
        assertEquals(localDF.format(expected), localDF.format(actual));


    }
}
