package NAU.controller.utils;

import net.sf.jasperreports.engine.*;

import java.util.HashMap;

/**
 * Created by SUSLOV on 24.09.2015.
 */
public class ReportCreator {

    public void createReport() {
        try {
            JasperReport jasperReport = JasperCompileManager
                    .compileReport("resources\\reports\\Uncertainty.jrxml");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                    new HashMap(), new JREmptyDataSource());




            JasperExportManager.exportReportToPdfFile(jasperPrint, "hello_report.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

}
