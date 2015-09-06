package NAU.controller;

import NAU.model.POJO.TableResultsContainer;
import NAU.view.ViewUtils;
import NAU.view.swing.CellEditionTableModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedList;

/**
 * Created by root on 05.09.2015.
 */
public class ControllerTest extends Assert {


    private DecimalFormat df;
    private DecimalFormatSymbols decimalFormatSymbols;

    @Before
    public void setUp() throws Exception {
        df = new DecimalFormat("0.00");
        decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        df.setRoundingMode(RoundingMode.HALF_UP);
        df.setDecimalFormatSymbols(decimalFormatSymbols);

    }


    @Test
    public void testGetResultForTable() throws Exception {
        LinkedList<Double> data = new LinkedList<Double>();
        data.add(0.58);data.add(5.09);data.add(0.83);data.add(1.16);data.add(3.63);

        Controller controller = new Controller();
        TableResultsContainer resultForTable = controller.getResultForData(data);
        StringBuilder sbExpected = new StringBuilder();
        StringBuilder sbActual = new StringBuilder();
        sbExpected.append("2.26" + " ");
        sbExpected.append("2.00" + " ");
        sbExpected.append("5.54" + " ");

        sbActual.append(df.format(resultForTable.getAmpMean()) + " ");
        sbActual.append(df.format(resultForTable.getStDev()) + " ");
        sbActual.append(df.format(resultForTable.getRepLim())+ " ");

        String expected = sbExpected.toString();
        String actual = sbActual.toString();

        assertEquals(expected,actual);
    }


}