package NAU.view.swing;

import NAU.controller.IController;
import NAU.model.POJO.TableResultsContainer;
import NAU.model.POJO.TableSingleMeasurementsResultContainer;
import NAU.view.ViewUtils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedList;


/**
 * Created by root on 05.09.2015.
 */
public class MainWindow extends JFrame {
    private JTable table5_10;

    private JTabbedPane tabbedPane1;

    private JPanel panelRoot;
    private JScrollPane jScrollTable5_10;
    private JTable table10_20;
    private JTable table20_40;
    private JTable table40_;
    private JLabel rser5_10;
    private JLabel sr5_10;
    private JLabel r5_10;
    private JLabel rser10_20;
    private JLabel sr10_20;
    private JLabel r10_20;
    private JLabel rser20_40;
    private JLabel sr20_40;
    private JLabel r20_40;
    private JLabel rser40_;
    private JLabel sr40_;
    private JLabel r40_;
    private JTable tableSingleMeasurement;
    private JLabel lableSingleMeasSr5_10;
    private JLabel lableSingleMeasR5_10;
    private JLabel lableSingleMeasR10_20;
    private JLabel lableSingleMeasR20_40;
    private JLabel lableSingleMeasR40_;
    private JLabel lableSingleMeasSr10_20;
    private JLabel lableSingleMeasSr20_40;
    private JLabel lableSingleMeasSr40_;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField4;
    private JTextField textField8;
    private JButton надрукуватиПротколButton;
    private JTextField textField7;

    private int rows;
    private int cols;

    DecimalFormat df;
    DecimalFormatSymbols decimalFormatSymbols;

    IController controller;
    ViewUtils viewUtils;

    public MainWindow(IController c)  {
        super("Оцінювання невизначеності для методики");
        controller = c;
        viewUtils = new ViewUtils(controller);

        setContentPane(panelRoot);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {"№", "W1, %", "W2, %", "R, %"};
        String[] columnNamesSingle = {"№","5-10", "10-20", "20-40", ">40"};

        df = new DecimalFormat("0.00");
        decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        df.setRoundingMode(RoundingMode.HALF_UP);
        df.setDecimalFormatSymbols(decimalFormatSymbols);

        rows = 20;
        cols = 4;
        final CellEditionTableModel tableModel5_10 = new CellEditionTableModel(rows,cols);
        final CellEditionTableModel tableModel10_20 = new CellEditionTableModel(rows,cols);
        final CellEditionTableModel tableModel20_40 = new CellEditionTableModel(rows,cols);
        final CellEditionTableModel tableModel40_ = new CellEditionTableModel(rows,cols);
        final CellEditionTableModel tableModelSingleMeasurements = new CellEditionTableModel(rows,5);

        modelConfigure(tableModel5_10, columnNames);
        modelConfigure(tableModel10_20, columnNames);
        modelConfigure(tableModel20_40, columnNames);
        modelConfigure(tableModel40_, columnNames);
        modelSingleMeasurementConfigure(tableModelSingleMeasurements, columnNamesSingle);

        tableConfigure(table5_10, tableModel5_10);
        tableConfigure(table10_20, tableModel10_20);
        tableConfigure(table20_40, tableModel20_40);
        tableConfigure(table40_, tableModel40_);
        tableConfigure(tableSingleMeasurement, tableModelSingleMeasurements);


        ListSelectionModel cellSelection5_10 = table5_10.getSelectionModel();
        cellSelection5_10.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelection5_10.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                viewUtils.tableAmplitudeCalculator(tableModel5_10);
                LinkedList<Double> data5_10 = viewUtils.getDataFromTable(tableModel5_10, 3);
                TableResultsContainer results5_10 = controller.getResultForData(data5_10);
                rser5_10.setText(df.format(results5_10.getAmpMean()));
                sr5_10.setText(df.format(results5_10.getStDev()));
                r5_10.setText(df.format(results5_10.getRepLim()));
            }
        });

        ListSelectionModel cellSelection10_20 = table10_20.getSelectionModel();
        cellSelection10_20.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelection10_20.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {

                viewUtils.tableAmplitudeCalculator(tableModel10_20);
                LinkedList<Double> data10_20 = viewUtils.getDataFromTable(tableModel10_20, 3);
                TableResultsContainer results10_20 = controller.getResultForData(data10_20);
                rser10_20.setText(df.format(results10_20.getAmpMean()));
                sr10_20.setText(df.format(results10_20.getStDev()));
                r10_20.setText(df.format(results10_20.getRepLim()));
            }
        });


        ListSelectionModel cellSelection20_40 = table20_40.getSelectionModel();
        cellSelection20_40.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelection20_40.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                viewUtils.tableAmplitudeCalculator(tableModel20_40);
                LinkedList<Double> data20_40 = viewUtils.getDataFromTable(tableModel20_40, 3);
                TableResultsContainer results20_40 = controller.getResultForData(data20_40);
                rser20_40.setText(df.format(results20_40.getAmpMean()));
                sr20_40.setText(df.format(results20_40.getStDev()));
                r20_40.setText(df.format(results20_40.getRepLim()));
            }
        });

        ListSelectionModel cellSelection40_ = table40_.getSelectionModel();
        cellSelection40_.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelection40_.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                viewUtils.tableAmplitudeCalculator(tableModel40_);
                LinkedList<Double> data40_ = viewUtils.getDataFromTable(tableModel40_, 3);
                TableResultsContainer results40_ = controller.getResultForData(data40_);
                rser40_.setText(df.format(results40_.getAmpMean()));
                sr40_.setText(df.format(results40_.getStDev()));
                r40_.setText(df.format(results40_.getRepLim()));
            }
        });

        ListSelectionModel cellSelectionTableSingle = tableSingleMeasurement.getSelectionModel();
        cellSelectionTableSingle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionTableSingle.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                /*Result calculation for crushability of 5_10mm */
                LinkedList<Double> data5_10 = viewUtils.getDataFromTable(tableModelSingleMeasurements, 1);
                TableSingleMeasurementsResultContainer results5_10 = controller.getResultForSingleMeasuredData(data5_10);
                lableSingleMeasSr5_10.setText(df.format(results5_10.getStDev()));
                lableSingleMeasR5_10.setText(df.format(results5_10.getRepLim()));
                /*Result calculation for crushability 10_20mm */
                LinkedList<Double> data10_20 = viewUtils.getDataFromTable(tableModelSingleMeasurements, 2);
                TableSingleMeasurementsResultContainer results10_20 = controller.getResultForSingleMeasuredData(data10_20);
                lableSingleMeasSr10_20.setText(df.format(results10_20.getStDev()));
                lableSingleMeasR10_20.setText(df.format(results10_20.getRepLim()));
                /*Result calculation for crushability 20_40mm */
                LinkedList<Double> data20_40 = viewUtils.getDataFromTable(tableModelSingleMeasurements, 3);
                TableSingleMeasurementsResultContainer results20_40 = controller.getResultForSingleMeasuredData(data20_40);
                lableSingleMeasSr20_40.setText(df.format(results20_40.getStDev()));
                lableSingleMeasR20_40.setText(df.format(results20_40.getRepLim()));
                /*Result calculation for crushability >40mm */
                LinkedList<Double> data40_ = viewUtils.getDataFromTable(tableModelSingleMeasurements, 4);
                TableSingleMeasurementsResultContainer results40_ = controller.getResultForSingleMeasuredData(data40_);
                lableSingleMeasSr40_.setText(df.format(results40_.getStDev()));
                lableSingleMeasR40_.setText(df.format(results40_.getRepLim()));
            }
        });





        setVisible(true);
        pack();
    }

    private void modelConfigure( CellEditionTableModel model, String[] columnNames) {
        model.setColumnIdentifiers(columnNames);
        for (int i = 0; i < 20; i++) {
            model.setValueAt(String.valueOf(i + 1), i, 0);
            model.setCellEditable(i, 0, false);
            model.setCellEditable(i, 1, true);
            model.setCellEditable(i, 2, true);
            model.setCellEditable(i, 3, false);
        }

    }

    private void modelSingleMeasurementConfigure( CellEditionTableModel model, String[] columnNames) {
        model.setColumnIdentifiers(columnNames);
        for (int i = 0; i < 20; i++) {
            model.setValueAt(String.valueOf(i + 1), i, 0);
            model.setCellEditable(i, 0, false);
            model.setCellEditable(i, 1, true);
            model.setCellEditable(i, 2, true);
            model.setCellEditable(i, 3, true);
            model.setCellEditable(i, 4, true);
        }

    }



    private void tableConfigure(JTable table, CellEditionTableModel model) {
        table.setModel(model);
        table.setRowSelectionAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

}
