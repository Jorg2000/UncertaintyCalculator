package NAU.view;

import NAU.controller.Controller;
import NAU.model.POJO.TableResultsContainer;
import NAU.view.swing.CellEditionTableModel;
import org.junit.Before;
import org.junit.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by root on 06.09.2015.
 */
public class ViewUtilsTest {


    int rows = 20;
    int cols = 4;
    private CellEditionTableModel testTableModel;
    private DecimalFormat df;
    private DecimalFormatSymbols decimalFormatSymbols;
    @Before
    public void setUp() throws Exception {
        df = new DecimalFormat("0,00");
        decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        df.setRoundingMode(RoundingMode.HALF_UP);
        df.setDecimalFormatSymbols(decimalFormatSymbols);
        testTableModel = new CellEditionTableModel(rows,cols);
    }

    @Test
    public void testTableAmplitudeCalculatorNormalCase() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);

        testTableModel.setValueAt("5,5", 0, 1);
        testTableModel.setValueAt("1,1", 0, 2);


        viewUtils.tableAmplitudeCalculator(testTableModel);
        String actual = (String)testTableModel.getValueAt(0,3);
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
        String actual = (String)testTableModel.getValueAt(0,3);
        assertNull(actual);
    }

    @Test
    public void testTableAmplitudeCalculatorWrongDataW2() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);

        testTableModel.setValueAt("5,5", 0, 1);
        testTableModel.setValueAt("", 0, 2);

        viewUtils.tableAmplitudeCalculator(testTableModel);
        String actual = (String)testTableModel.getValueAt(0,3);
        assertNull(actual);
    }

    @Test
    public void testTableAmplitudeCalculatorMinusSignInData() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);

        testTableModel.setValueAt("2,2", 0, 1);
        testTableModel.setValueAt("-1,1", 0, 2);

        viewUtils.tableAmplitudeCalculator(testTableModel);
        String actual = (String)testTableModel.getValueAt(0,3);
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
        String actual = (String)testTableModel.getValueAt(0,3);
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
        String actual = (String)testTableModel.getValueAt(0, 3);

        assertNull(actual);
    }

    @Test
    public void testGetResultsDataFromTableNormalData() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);
        LinkedList<Double> expected = new LinkedList<Double>();
        expected.add(1.1);expected.add(2.2);expected.add(3.3);

        testTableModel.setValueAt("1,1", 0, 3);
        testTableModel.setValueAt("2,2", 1, 3);
        testTableModel.setValueAt("3,3", 2, 3);

        LinkedList<Double> actual = viewUtils.getDataFromTable(testTableModel);
        assertEquals(expected,actual);

    }

    @Test
    public void testGetResultsDataFromTableEmptyResults() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);
        LinkedList<Double> expected = new LinkedList<Double>();
        expected.add(1.1);expected.add(3.3);

        testTableModel.setValueAt("1,1", 0, 3);
        testTableModel.setValueAt("", 1, 3);
        testTableModel.setValueAt("3,3", 2, 3);
        LinkedList<Double> actual  = viewUtils.getDataFromTable(testTableModel);

        assertEquals(expected,actual);
    }

    @Test
    public void testGetResultsDataFromTableHasNULLData() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);
        LinkedList<Double> expected = new LinkedList<Double>();
        expected.add(1.1);expected.add(3.3);
        testTableModel.setValueAt("1,1", 0, 3);
        testTableModel.setValueAt("3.3", 1, 3);
        testTableModel.setValueAt(null, 2, 3);
        LinkedList<Double> actual = viewUtils.getDataFromTable(testTableModel);
        assertEquals(expected,actual);
    }

    @Test
    public void testGetResultsDataFromTableHasNoData() throws Exception {
        Controller controller = new Controller();
        ViewUtils viewUtils = new ViewUtils(controller);
        LinkedList<Double> expected = new LinkedList<Double>();
        LinkedList<Double> actual = viewUtils.getDataFromTable(testTableModel);
        assertEquals(expected,actual);
    }

}