package NAU.view;

import NAU.controller.IController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ViewUtils {

    private final DecimalFormat df;
    Pattern cellTextPattern;
    private IController controller;


    public ViewUtils(IController c) {
        controller = c;
        df = new DecimalFormat("0.00");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator(',');
        df.setRoundingMode(RoundingMode.HALF_UP);
        df.setDecimalFormatSymbols(decimalFormatSymbols);
        cellTextPattern = Pattern.compile("(^[0-9.,-]+$)");
    }

    public LinkedList<Double> getDataFromTable(DefaultTableModel model, int col) {

        LinkedList<Double> amplitudes = new LinkedList<Double>();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, col) != null) {
                String curr = ((String) model.getValueAt(i, col)).trim();
                if (!curr.equals("")) {
                    if (stringIsNumber(curr)) {
                        curr = curr.replace(',', '.');
                        amplitudes.add(Double.parseDouble(curr));
                    }
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

        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 1) != null & model.getValueAt(i, 2) != null) {
                w1String = ((String) model.getValueAt(i, 1)).trim();
                w2String = ((String) model.getValueAt(i, 2)).trim();

                if (stringIsNumber(w1String) & stringIsNumber(w2String)) {
                    w1String = w1String.replace(',', '.');
                    w2String = w2String.replace(',', '.');
                    w1 = Double.parseDouble(w1String);
                    w2 = Double.parseDouble(w2String);
                    model.setValueAt(df.format(controller.amplitude(w1, w2)), i, 3);
                } else {
                    model.setValueAt(null, i, 3);
                }
            }
        }
    }

    public boolean stringIsNumber(String str) {
        String data;
        if (str != null) {
            data = str;
            Pattern cellTextPattern;
            cellTextPattern = Pattern.compile("(^[0-9.,-]+$)");
            Matcher matcher = cellTextPattern.matcher(data);
            return matcher.find();
        } else {
            return false;
        }
    }

    /*Taking double number from JTextfield object*/
    public double getDoubleNumberFromTextField(JTextField jTextField) {
        if (jTextField != null) {
            String curr = jTextField.getText().trim();
            if (!curr.equals("")) {
                if (stringIsNumber(curr)) {
                    curr = curr.replace(',', '.');
                    return Double.parseDouble(curr);
                }
            }
        }
        return 0;
    }

}
