package NAU.view;

import NAU.controller.IController;

import javax.swing.table.DefaultTableModel;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by root on 06.09.2015.
 */
public class ViewUtils {

    private final DecimalFormat df;
    private final DecimalFormatSymbols decimalFormatSymbols;
    private IController controller;

    public ViewUtils(IController c) {
        controller = c;
        df = new DecimalFormat("0.00");
        decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator(',');
        df.setRoundingMode(RoundingMode.HALF_UP);
        df.setDecimalFormatSymbols(decimalFormatSymbols);
    }

    public LinkedList<Double> getDataFromTable(DefaultTableModel model) {
        LinkedList<Double> amplitudes = new LinkedList<Double>();
        for (int i = 0; i < model.getRowCount() ; i++) {
            if (model.getValueAt(i,3) != null) {
                String curr = (String)model.getValueAt(i,3);
                if (!curr.equals("")) {
                    curr = curr.replace(',', '.');
                    amplitudes.add(Double.parseDouble(curr));
                }
            }
        }
        return amplitudes;
    }

    public void tableAmplitudeCalculator(DefaultTableModel model) {

        double w1;
        double w2;
        String w1String;
        String w2String;
        Pattern p = Pattern.compile("(^[0-9.,-]+$)");

        for (int i = 0; i < model.getRowCount() ; i++) {
            if (model.getValueAt(i,1) != null & model.getValueAt(i,2) != null) {
                w1String = (String) model.getValueAt(i,1);
                w2String = (String) model.getValueAt(i,2);
                Matcher matchW1 = p.matcher(w1String);
                Matcher matchW2 = p.matcher(w2String);
                if (matchW1.find() & matchW2.find()) {
                    w1String = w1String.replace(',', '.');
                    w2String = w2String.replace(',', '.');
                    w1 = Double.parseDouble(w1String);
                    w2 = Double.parseDouble(w2String);
                    model.setValueAt(df.format(controller.amplitude(w1, w2)),i,3);
                }
                else {
                    model.setValueAt(null, i, 3);
                }
            }
        }
    }
}
