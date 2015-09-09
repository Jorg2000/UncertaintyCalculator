package NAU.view;

import NAU.controller.Controller;
import NAU.view.swing.CellEditionTableModel;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedList;

import static org.junit.Assert.*;


public class ViewUtilsTest {

    private CellEditionTableModel testTableModel;
    private DecimalFormat df;
    private DecimalFormatSymbols decimalFormatSymbols;

    @Before
    public void setUp() throws Exception {
        df = new DecimalFormat("0.00");
        decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        df.setRoundingMode(RoundingMode.HALF_UP);
        df.setDecimalFormatSymbols(decimalFormatSymbols);
        int rows = 20;
        int cols = 4;
        testTableModel = new CellEditionTableModel(rows, cols);
    }

    @Test
    public void testTableAmplitudeCalculatorNormalCase() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);

        testTableModel.setValueAt("5,5", 0, 1);
        testTableModel.setValueAt("1,1", 0, 2);


        viewUtils.tableAmplitudeCalculator(testTableModel);
        String actual = (String) testTableModel.getValueAt(0, 3);
        String expected = "4,40";
        assertEquals(expected, actual);
    }

    @Test
    public void testTableAmplitudeCalculatorWrongDataW1() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);

        testTableModel.setValueAt("", 0, 1);
        testTableModel.setValueAt("1,1", 0, 2);


        viewUtils.tableAmplitudeCalculator(testTableModel);
        String actual = (String) testTableModel.getValueAt(0, 3);
        assertNull(actual);
    }

    @Test
    public void testTableAmplitudeCalculatorWrongDataW2() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);

        testTableModel.setValueAt("5,5", 0, 1);
        testTableModel.setValueAt("", 0, 2);

        viewUtils.tableAmplitudeCalculator(testTableModel);
        String actual = (String) testTableModel.getValueAt(0, 3);
        assertNull(actual);
    }

    @Test
    public void testTableAmplitudeCalculatorMinusSignInData() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);

        testTableModel.setValueAt("2,2", 0, 1);
        testTableModel.setValueAt("-1,1", 0, 2);

        viewUtils.tableAmplitudeCalculator(testTableModel);
        String actual = (String) testTableModel.getValueAt(0, 3);
        String expected = "3,30";
        assertEquals(expected, actual);
    }

    @Test
    public void testTableAmplitudeCalculatorPointInData() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);

        testTableModel.setValueAt("2.2", 0, 1);
        testTableModel.setValueAt("-1.1", 0, 2);


        viewUtils.tableAmplitudeCalculator(testTableModel);
        String actual = (String) testTableModel.getValueAt(0, 3);
        String expected = "3,30";
        assertEquals(expected, actual);
    }

    @Test
    public void testTableAmplitudeCalculatorPutNULLTest() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);

        testTableModel.setValueAt("lksdjlkf", 0, 1);
        testTableModel.setValueAt("-1.1", 0, 2);
        testTableModel.setValueAt("-1.1", 0, 3);

        viewUtils.tableAmplitudeCalculator(testTableModel);
        String actual = (String) testTableModel.getValueAt(0, 3);

        assertNull(actual);
    }

    @Test
    public void testGetResultsDataFromTableNormalData() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);
        LinkedList<Double> expected = new LinkedList<Double>();
        expected.add(1.1);
        expected.add(2.2);
        expected.add(3.3);

        testTableModel.setValueAt("1,1", 0, 3);
        testTableModel.setValueAt("2,2", 1, 3);
        testTableModel.setValueAt("3,3", 2, 3);

        LinkedList<Double> actual = viewUtils.getDataFromTable(testTableModel, 3);
        assertEquals(expected, actual);

    }

    @Test
    public void testGetResultsDataFromTableEmptyResults() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);
        LinkedList<Double> expected = new LinkedList<Double>();
        expected.add(1.1);
        expected.add(3.3);

        testTableModel.setValueAt("1,1", 0, 3);
        testTableModel.setValueAt("", 1, 3);
        testTableModel.setValueAt("3,3", 2, 3);
        LinkedList<Double> actual = viewUtils.getDataFromTable(testTableModel, 3);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetResultsDataFromTableHasNULLData() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);
        LinkedList<Double> expected = new LinkedList<Double>();
        expected.add(1.1);
        expected.add(3.3);
        testTableModel.setValueAt("1,1", 0, 3);
        testTableModel.setValueAt("3.3", 1, 3);
        testTableModel.setValueAt(null, 2, 3);
        LinkedList<Double> actual = viewUtils.getDataFromTable(testTableModel, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetResultsDataFromTableHasSpacesData() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);
        LinkedList<Double> expected = new LinkedList<Double>();
        expected.add(1.1);
        expected.add(3.3);
        testTableModel.setValueAt(" 1,1 ", 0, 3);
        testTableModel.setValueAt(" 3.3 ", 1, 3);
        testTableModel.setValueAt(null, 2, 3);
        LinkedList<Double> actual = viewUtils.getDataFromTable(testTableModel, 3);
        assertEquals(expected, actual);
    }


    @Test
    public void testGetResultsDataFromTableHasNoData() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);
        LinkedList<Double> expected = new LinkedList<Double>();
        LinkedList<Double> actual = viewUtils.getDataFromTable(testTableModel, 3);
        assertEquals(expected, actual);
    }

    /*Input string contains string with normal fractional or integer number*/
    @Test
    public void testStringIsNumberNormalData() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);
        String testString = "0.95";
        boolean result = viewUtils.stringIsNumber(testString);
        assertTrue(result);
    }

    /*Input string contains comma as decimal separator*/
    @Test
    public void testStringIsNumberCommaSeparator() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);
        String testString = "0,95";
        boolean result = viewUtils.stringIsNumber(testString);
        assertTrue(result);
    }

    /*Input string contains spaces before and after the number*/
    @Test
    public void testStringIsNumberHasSpaceBeforeAndAfter() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);
        String testString = " 0,95 ";
        boolean result = viewUtils.stringIsNumber(testString);
        assertFalse(result);
    }

    /*Input string doesn't contains numbers*/
    @Test
    public void testStringIsNumberBadData() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);
        String testString = "xyz";
        boolean result = viewUtils.stringIsNumber(testString);
        assertFalse(result);
    }

    /*Input string is NULL*/
    @Test
    public void testStringIsNumberNULLData() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);
        String testString = null;
        boolean result = viewUtils.stringIsNumber(testString);
        assertFalse(result);
    }

    /*Input string is empty*/
    @Test
    public void testStringIsNumberEmptyData() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);
        String testString = "";
        boolean result = viewUtils.stringIsNumber(testString);
        assertFalse(result);
    }

    /*Current test field has ordinary string with fractional or integer number*/
    @Test
    public void testGetDoubleNumberFromTextFieldNormalData() throws Exception {

        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);
        JTextField testField = new JTextField();
        testField.setText("0,95");
        double expected = 0.95;
        double actual = viewUtils.getDoubleNumberFromTextField(testField);
        assertEquals(df.format(expected), df.format(actual));

    }

    /*Current test field has bad data (text and random symbols)*/
    @Test
    public void testGetDoubleNumberFromTextFieldBadData() throws Exception {

        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);
        JTextField testField = new JTextField();
        testField.setText("akjshkjasdh-123,.");
        double expected = 0;
        double actual = viewUtils.getDoubleNumberFromTextField(testField);
        assertEquals(df.format(expected), df.format(actual));
    }

    /*Current test field has bad data (text and random symbols)*/
    @Test
    public void testGetDoubleNumberFromTextFieldNULLData() throws Exception {

        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);
        JTextField testField = null;
        double expected = 0;
        double actual = viewUtils.getDoubleNumberFromTextField(testField);
        assertEquals(df.format(expected), df.format(actual));
    }
}