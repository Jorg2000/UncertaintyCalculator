package NAU.controller.utils;

import NAU.model.POJO.ProtocolDataContainer;
import NAU.model.POJO.UncertaintyDataContainer;
import net.sf.jasperreports.engine.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SUSLOV on 24.09.2015.
 */
public class ReportCreator {

    public void createReport(ProtocolDataContainer pdc) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DecimalFormat df = new DecimalFormat("0.00");
        Map parameters = new HashMap<String,Object>();


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

        try {
            JasperReport jasperReport = JasperCompileManager
                    .compileReport("resources\\reports\\Uncertainty.jrxml");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                    parameters, new JREmptyDataSource());

            JasperExportManager.exportReportToPdfFile(jasperPrint, "hello_report.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

}
