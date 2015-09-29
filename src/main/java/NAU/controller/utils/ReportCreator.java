package NAU.controller.utils;

import NAU.model.POJO.Graph.GraphDataContainer;
import NAU.model.POJO.MeasurementDataContainer;
import NAU.model.POJO.ProtocolDataContainer;
import NAU.model.POJO.SingleMeasurementDataContainer;
import NAU.model.POJO.UncertaintyDataContainer;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by SUSLOV on 24.09.2015.
 */
public class ReportCreator {

    public void createReport(ProtocolDataContainer pdc) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DecimalFormat df = new DecimalFormat("0.00");
        Map parameters = new HashMap<String,Object>();

        ArrayList<MeasurementDataContainer> data5_10 = new ArrayList<MeasurementDataContainer>();
        ArrayList<MeasurementDataContainer> data10_20 = new ArrayList<MeasurementDataContainer>();
        ArrayList<MeasurementDataContainer> data20_40 = new ArrayList<MeasurementDataContainer>();
        ArrayList<MeasurementDataContainer> data40_ = new ArrayList<MeasurementDataContainer>();
        ArrayList<GraphDataContainer> graphData = new ArrayList<GraphDataContainer>();
        graphData.add(new GraphDataContainer(0.12,"5 - 10"));
        graphData.add(new GraphDataContainer(0.18,"10 - 20"));
        graphData.add(new GraphDataContainer(0.25,"20 - 40"));
        graphData.add(new GraphDataContainer(0.16," > 40"));


        ArrayList<SingleMeasurementDataContainer> dataSingle = new ArrayList<SingleMeasurementDataContainer>();
        dataSingle.add(new SingleMeasurementDataContainer("1", "1.11", "1.12", "1.13", "1.14"));
        dataSingle.add(new SingleMeasurementDataContainer("2", "2.11", "2.12", "2.13", "2.14"));
        dataSingle.add(new SingleMeasurementDataContainer("3", "3.11", "3.12", "3.13", "3.14"));
        dataSingle.add(new SingleMeasurementDataContainer("4", "4.11", "4.12", "4.13", "4.14"));


        data5_10.add(new MeasurementDataContainer("1", "1.1", "1.1", "1.1"));
        data5_10.add(new MeasurementDataContainer("2", "2.1", "2.1", "2.1"));
        data5_10.add(new MeasurementDataContainer("3", "3.1", "2.2", "0.1"));

        data10_20.add(new MeasurementDataContainer("1", "1.1", "1.1", "1.1"));
        data10_20.add(new MeasurementDataContainer("2", "2.1", "2.1", "2.1"));
        data10_20.add(new MeasurementDataContainer("3", "3.1", "2.2", "0.1"));

        data20_40.add(new MeasurementDataContainer("1", "1.1", "1.1", "1.1"));
        data20_40.add(new MeasurementDataContainer("2", "2.1", "2.1", "2.1"));
        data20_40.add(new MeasurementDataContainer("3", "3.1", "2.2", "0.1"));


        data40_.add(new MeasurementDataContainer("1", "1.1", "1.1", "1.1"));
        data40_.add(new MeasurementDataContainer("2", "2.1", "2.1", "2.1"));
        data40_.add(new MeasurementDataContainer("3", "3.1", "2.2", "0.1"));

        parameters.put("data5_10", new JRBeanCollectionDataSource(data5_10));
        parameters.put("data10_20", new JRBeanCollectionDataSource(data10_20));
        parameters.put("data20_40", new JRBeanCollectionDataSource(data20_40));
        parameters.put("data40_", new JRBeanCollectionDataSource(data40_));

        parameters.put("dataSingle", new JRBeanCollectionDataSource(dataSingle));
        parameters.put("graphData1_1", new JRBeanCollectionDataSource(graphData));

        parameters.put("protNumber", pdc.getProtocolNumber());
        parameters.put("protDate", dateFormat.format(pdc.getProtocolIssuedDate().getTime()));

        parameters.put("rser5_10",df.format(pdc.getResults5_10().getAmpMean()));
        parameters.put("sr5_10", df.format(pdc.getResults5_10().getStDev()));
        parameters.put("r5_10", df.format(pdc.getResults5_10().getRepLim()));

        parameters.put("rser10_20",df.format(pdc.getResults10_20().getAmpMean()));
        parameters.put("sr10_20", df.format(pdc.getResults10_20().getStDev()));
        parameters.put("r10_20", df.format(pdc.getResults10_20().getRepLim()));

        parameters.put("rser20_40",df.format(pdc.getResults20_40().getAmpMean()));
        parameters.put("sr20_40", df.format(pdc.getResults20_40().getStDev()));
        parameters.put("r20_40", df.format(pdc.getResults20_40().getRepLim()));

        parameters.put("rser40_",df.format(pdc.getResults40_().getAmpMean()));
        parameters.put("sr40_", df.format(pdc.getResults40_().getStDev()));
        parameters.put("r40_", df.format(pdc.getResults40_().getRepLim()));

        parameters.put("sr5_10_Single", "0.00");
        parameters.put("sr10_20_Single", "0.00");
        parameters.put("sr20_40_Single", "0.00");
        parameters.put("sr40_Single", "0.00");

        parameters.put("r5_10_Single", "0.00");
        parameters.put("r10_20_Single", "0.00");
        parameters.put("r20_40_Single", "0.00");
        parameters.put("r40_Single", "0.00");



        try {
            JasperReport jasperReport = JasperCompileManager
                    .compileReport("resources\\reports\\Uncertainty.jrxml");


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                    parameters, new JREmptyDataSource());

            JasperViewer.viewReport(jasperPrint);

            JasperExportManager.exportReportToPdfFile(jasperPrint, "hello_report.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

}
