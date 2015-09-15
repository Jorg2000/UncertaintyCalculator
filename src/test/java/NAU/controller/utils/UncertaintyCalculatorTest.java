package NAU.controller.utils;

import NAU.model.POJO.UncertaintyDataContainer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import static org.junit.Assert.*;

/**
 * Created by SUSLOV on 15.09.2015.
 */
public class UncertaintyCalculatorTest extends Assert {
    private DecimalFormat df;

    @Before
    public void setUp() throws Exception {

        df = new DecimalFormat("0.00");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        df.setRoundingMode(RoundingMode.HALF_UP);
        df.setDecimalFormatSymbols(decimalFormatSymbols);

    }

    @Test
    public void testGetInfluenceCoefCM1_A() throws Exception {
        UncertaintyDataContainer dataContainer = new UncertaintyDataContainer(1.0, 1361.9, 1326.8, 1.31);
        UncertaintyCalculator uc = new UncertaintyCalculator(dataContainer);
        double actual = uc.getInfluenceCoefCM1();
        double expected = 0.08;
        assertEquals(df.format(expected), df.format(actual));
    }

    @Test
    public void testGetInfluenceCoefCM1CxUx_A() throws Exception {
        DecimalFormat localDF = new DecimalFormat("0.0");
        UncertaintyDataContainer dataContainer = new UncertaintyDataContainer(1.0, 1361.9, 1326.8, 1.31);
        UncertaintyCalculator uc = new UncertaintyCalculator(dataContainer);
        double actual = uc.getInfluenceCoefCM1CxUx();
        double expected = 0.1;
        assertEquals(localDF.format(expected), localDF.format(actual));
    }

    @Test
    public void testGetConstMassUncertainty_A() throws Exception {
        UncertaintyDataContainer dataContainer = new UncertaintyDataContainer(1.0, 1361.9, 1326.8, 1.31);
        UncertaintyCalculator uc = new UncertaintyCalculator(dataContainer);
        double actual = uc.getConstMassUncertainty();
        double expected = 38.30;
        assertEquals(df.format(expected), df.format(actual));
    }

    @Test
    public void testGetInfluenceCoefCM_A() throws Exception {
        UncertaintyDataContainer dataContainer = new UncertaintyDataContainer(1.0, 1361.9, 1326.8, 1.31);
        UncertaintyCalculator uc = new UncertaintyCalculator(dataContainer);
        double actual = uc.getInfluenceCoefCM();
        double expected = 0.08;
        assertEquals(df.format(expected), df.format(actual));
    }

    @Test
    public void testGetInfluenceCoefCMCxUx() throws Exception {
        DecimalFormat localDF = new DecimalFormat("0.0");
        UncertaintyDataContainer dataContainer = new UncertaintyDataContainer(1.0, 1361.9, 1326.8, 1.31);
        UncertaintyCalculator uc = new UncertaintyCalculator(dataContainer);
        double actual = uc.getInfluenceCoefCMCxUx();
        double expected = 0.1;
        assertEquals(localDF.format(expected), localDF.format(actual));
    }

    @Test
    public void testGetRoundnessUncertainty() throws Exception {
        UncertaintyDataContainer dataContainer = new UncertaintyDataContainer(1.0, 1361.9, 1326.8, 1.31);
        UncertaintyCalculator uc = new UncertaintyCalculator(dataContainer);
        double actual = uc.getRoundnessUncertainty();
        double expected = 0.29;
        assertEquals(df.format(expected), df.format(actual));
    }

    @Test
    public void testGetConvergence() throws Exception {
        UncertaintyDataContainer dataContainer = new UncertaintyDataContainer(1.0, 1361.9, 1326.8, 1.31);
        UncertaintyCalculator uc = new UncertaintyCalculator(dataContainer);
        double actual = uc.getConvergence();
        double expected = 0.47;
        assertEquals(df.format(expected), df.format(actual));
    }

    @Test
    public void testGetTotalStandUncertainty() throws Exception {
        UncertaintyDataContainer dataContainer = new UncertaintyDataContainer(1.0, 1361.9, 1326.8, 1.31314409);
        UncertaintyCalculator uc = new UncertaintyCalculator(dataContainer);
        double actual = uc.getTotalStandUncertainty();
        double expected = 0.46;
        assertEquals(df.format(expected), df.format(actual));

    }

    @Test
    public void testGetExtendedUncertainty() throws Exception {
        UncertaintyDataContainer dataContainer = new UncertaintyDataContainer(1.0, 1361.9, 1326.8, 1.31314409);
        UncertaintyCalculator uc = new UncertaintyCalculator(dataContainer);
        double actual = uc.getExtendedUncertainty();
        double expected = 0.91;
        assertEquals(df.format(expected), df.format(actual));
    }
}