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
    }
