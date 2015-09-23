package NAU.controller.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedList;

public class MathUtilsTest extends Assert {

    private LinkedList<Double> data;
    private DecimalFormat df;


    @Before
    public void setUpData() {
        data = new LinkedList<Double>();
        data.add(0.58);
        data.add(5.09);
        data.add(0.83);
        data.add(1.16);
        data.add(3.63);
        data.add(5.29);
        data.add(2.37);
        data.add(4.03);
        data.add(3.25);
        data.add(0.52);
        data.add(1.91);
        data.add(0.25);
        data.add(6.84);
        data.add(0.55);
        data.add(4.95);
        data.add(0.74);
        data.add(3.96);
        data.add(1.89);
        data.add(1.92);
        data.add(6.25);
        df = new DecimalFormat("0.00");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        df.setRoundingMode(RoundingMode.HALF_UP);
        df.setDecimalFormatSymbols(decimalFormatSymbols);
    }

    @Test
    public void testMeanAmplitude() throws Exception {
        MathUtils mc = new MathUtils();
        double actual = mc.mean(data);
        double expected = 2.80;
        assertEquals(df.format(expected), df.format(actual));
    }

    @Test
    public void testStanDevByConst() throws Exception {
        MathUtils mc = new MathUtils();
        double actual = mc.stanDevByConst(mc.mean(data));
        double expected = 2.48;
        assertEquals(df.format(expected), df.format(actual));
    }

    @Test
    public void testRepeatabilityLimit() throws Exception {
        MathUtils mc = new MathUtils();
        double actual = mc.repeatabilityLimit(mc.stanDevByConst(mc.mean(data)));
        double expected = 6.87;
        assertEquals(df.format(expected), df.format(actual));

    }

    @Test
    public void testStanDev() throws Exception {
        MathUtils mc = new MathUtils();
        double actual = mc.stanDev(data);
        double expected = 2.09;
        assertEquals(df.format(expected), df.format(actual));
    }

    @Test
    public void testCrushabilityA() throws Exception {

        DecimalFormat localDF = new DecimalFormat("0.0");
        MathUtils mc = new MathUtils();
        double sampleMass = 1344.2;
        double remainMass = 1324.2;
        double actual = mc.crushability(sampleMass, remainMass);
        double expected = 1.5;
        assertEquals(localDF.format(expected), localDF.format(actual));

    }

    @Test
    public void testCrushabilityB() throws Exception {

        DecimalFormat localDF = new DecimalFormat("0.0");
        MathUtils mc = new MathUtils();
        double sampleMass = 1330.1;
        double remainMass = 1319.1;
        double actual = mc.crushability(sampleMass, remainMass);
        double expected = 0.8;
        assertEquals(localDF.format(expected), localDF.format(actual));

    }

    @Test
    public void testInfluenceCoeff() throws Exception {
        DecimalFormat localDF = new DecimalFormat("0.00");
        MathUtils mc = new MathUtils();
        double amount = 1321.7;
        double actual = mc.influenceCoeffCM1(amount);
        double expected = 0.08;
        assertEquals(localDF.format(expected), localDF.format(actual));
    }

    @Test
    public void testConstMassUncertaintyA() throws Exception {

        MathUtils mc = new MathUtils();
        double mass = 1321.7;
        double actual = mc.constMassUncertainty(mass);
        double expected = 38.15;
        assertEquals(df.format(expected), df.format(actual));
    }

    @Test
    public void testConstMassUncertaintyB() throws Exception {

        MathUtils mc = new MathUtils();
        double mass = 1319.7;
        double actual = mc.constMassUncertainty(mass);
        double expected = 38.10;
        assertEquals(df.format(expected), df.format(actual));
    }

    @Test
    public void testInfluenceCoeffUxCx() throws Exception {
        MathUtils mc = new MathUtils();
        DecimalFormat localDF = new DecimalFormat("0.0");
        double stdUncertainty = 1.00;
        double influenceCoeff = 0.08;
        double actual = mc.uncertaintyWithInfluenceCoeff(stdUncertainty, influenceCoeff);
        double expected = 0.1;
        assertEquals(localDF.format(expected), localDF.format(actual));
    }

    @Test
    public void testInfluenceCoeffUMA() throws Exception {
        MathUtils mc = new MathUtils();
        double sampleMeanMass = 1341.7;
        double remainMeanMass = 1321.7;
        double actual = mc.influenceCoeffUM(sampleMeanMass, remainMeanMass);
        double expected = 0.08;
        assertEquals(df.format(expected), df.format(actual));
    }

    @Test
    public void testInfluenceCoeffUMB() throws Exception {
        MathUtils mc = new MathUtils();
        double sampleMeanMass = 1361.9;
        double remainMeanMass = 1326.8;
        double actual = mc.influenceCoeffUM(sampleMeanMass, remainMeanMass);
        double expected = 0.08;
        assertEquals(df.format(expected), df.format(actual));
    }

    @Test
    public void testRoundnessUncertaintyA() throws Exception {
        MathUtils mc = new MathUtils();
        double roundness = 1;
        double actual = mc.roundnessUncertainty(roundness);
        double expected = 0.29;
        assertEquals(df.format(expected), df.format(actual));
    }

    @Test
    public void testRoundnessUncertaintyB() throws Exception {
        MathUtils mc = new MathUtils();
        double roundness = 5;
        double actual = mc.roundnessUncertainty(roundness);
        double expected = 1.44;
        assertEquals(df.format(expected), df.format(actual));
    }

    @Test
    public void testConvergenceA() throws Exception {
        MathUtils mc = new MathUtils();
        double maxDiffBetweenResults = 1.31;
        double actual = mc.convergence(maxDiffBetweenResults);
        double expected = 0.47;
        assertEquals(df.format(expected), df.format(actual));
    }

    @Test
    public void testConvergenceB() throws Exception {
        MathUtils mc = new MathUtils();
        double maxDiffBetweenResults = 2.87;
        double actual = mc.convergence(maxDiffBetweenResults);
        double expected = 1.04;
        assertEquals(df.format(expected), df.format(actual));
    }

    @Test
     public void testTotalStandardUncertaintyA() throws Exception {
        MathUtils mc = new MathUtils();
        double stdUncertaintyUM1 = 1.00;
        double influenceCoeffCM1 = 0.08;
        double stdUncertaintyUM = 1.00;
        double influenceCoeffCM = 0.08;
        double roundnessUncertainty = 0.29;
        double convergence = 0.47;
        double actual = mc.totalStandardUncertainty(stdUncertaintyUM1, influenceCoeffCM1, stdUncertaintyUM, influenceCoeffCM,
                roundnessUncertainty, convergence);
        double expected = 0.46;
        assertEquals(df.format(expected), df.format(actual));
    }

    @Test
    public void testTotalStandardUncertaintyB() throws Exception {
        MathUtils mc = new MathUtils();
        double stdUncertaintyUM1 = 2.00;
        double influenceCoeffCM1 = 0.15;
        double stdUncertaintyUM = 1.50;
        double influenceCoeffCM = 0.33;
        double roundnessUncertainty = 0.45;
        double convergence = 0.21;
        double actual = mc.totalStandardUncertainty(stdUncertaintyUM1,influenceCoeffCM1,stdUncertaintyUM,influenceCoeffCM,
                roundnessUncertainty,convergence);
        double expected = 0.75;
        assertEquals(df.format(expected), df.format(actual));
    }

    @Test
    public void testExtendedUncertainty() throws Exception {
        MathUtils mc = new MathUtils();
        DecimalFormat localDF = new DecimalFormat("0.0");
        double totalStandartUncertainty = 0.4553;
        double actual = mc.extendedUncertainty(totalStandartUncertainty);
        double expected = 0.9;
        assertEquals(localDF.format(expected), localDF.format(actual));


    }
}
