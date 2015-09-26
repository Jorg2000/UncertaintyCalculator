package NAU.model.POJO;

import NAU.controller.utils.UncertaintyCalculator;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by root on 26.09.2015.
 */
public class ProtocolDataContainer {
    /*General data for the protocol*/
    private String protocolNumber;
    private Calendar protocolIssuedDate;
    private String sampleNumber;
    /*Data from tables with many measurements*/
    private TableResultsContainer results5_10;
    private TableResultsContainer results10_20;
    private TableResultsContainer results20_40;
    private TableResultsContainer results40_;

    /*Data from one measurement*/
    private TableSingleMeasurementsResultContainer SingleResults5_10;
    private TableSingleMeasurementsResultContainer SingleResults10_20;
    private TableSingleMeasurementsResultContainer SingleResults20_40;
    private TableSingleMeasurementsResultContainer SingleResults40_;

    /*Uncertainty data*/
    private UncertaintyCalculator uncertaintyCalculator;

    public ProtocolDataContainer() {
        protocolNumber = "";
        protocolIssuedDate = Calendar.getInstance();
        sampleNumber = "";

        results5_10 = new TableResultsContainer();
        results10_20 = new TableResultsContainer();
        results20_40 = new TableResultsContainer();
        results40_ = new TableResultsContainer();

        SingleResults5_10 = new TableSingleMeasurementsResultContainer();
        SingleResults10_20 = new TableSingleMeasurementsResultContainer();
        SingleResults20_40 = new TableSingleMeasurementsResultContainer();
        SingleResults40_ = new TableSingleMeasurementsResultContainer();
    }

    public ProtocolDataContainer(String protocolNumber, Calendar protocolIssuedDate, String sampleNumber) {
        this.protocolNumber = protocolNumber;
        this.protocolIssuedDate = protocolIssuedDate;
        this.sampleNumber = sampleNumber;
    }

    public String getProtocolNumber() {
        return protocolNumber;
    }

    public void setProtocolNumber(String protocolNumber) {
        this.protocolNumber = protocolNumber;
    }

    public Calendar getProtocolIssuedDate() {
        return protocolIssuedDate;
    }

    public void setProtocolIssuedDate(Calendar protocolIssuedDate) {
        this.protocolIssuedDate = protocolIssuedDate;
    }

    public String getSampleNumber() {
        return sampleNumber;
    }

    public void setSampleNumber(String sampleNumber) {
        this.sampleNumber = sampleNumber;
    }

    public TableResultsContainer getResults5_10() {
        return results5_10;
    }

    public void setResults5_10(TableResultsContainer results5_10) {
        this.results5_10 = results5_10;
    }

    public TableResultsContainer getResults10_20() {
        return results10_20;
    }

    public void setResults10_20(TableResultsContainer results10_20) {
        this.results10_20 = results10_20;
    }

    public TableResultsContainer getResults20_40() {
        return results20_40;
    }

    public void setResults20_40(TableResultsContainer results20_40) {
        this.results20_40 = results20_40;
    }

    public TableResultsContainer getResults40_() {
        return results40_;
    }

    public void setResults40_(TableResultsContainer results40_) {
        this.results40_ = results40_;
    }

    public TableSingleMeasurementsResultContainer getSingleResults5_10() {
        return SingleResults5_10;
    }

    public void setSingleResults5_10(TableSingleMeasurementsResultContainer singleResults5_10) {
        SingleResults5_10 = singleResults5_10;
    }

    public TableSingleMeasurementsResultContainer getSingleResults10_20() {
        return SingleResults10_20;
    }

    public void setSingleResults10_20(TableSingleMeasurementsResultContainer singleResults10_20) {
        SingleResults10_20 = singleResults10_20;
    }

    public TableSingleMeasurementsResultContainer getSingleResults20_40() {
        return SingleResults20_40;
    }

    public void setSingleResults20_40(TableSingleMeasurementsResultContainer singleResults20_40) {
        SingleResults20_40 = singleResults20_40;
    }

    public TableSingleMeasurementsResultContainer getSingleResults40_() {
        return SingleResults40_;
    }

    public void setSingleResults40_(TableSingleMeasurementsResultContainer singleResults40_) {
        SingleResults40_ = singleResults40_;
    }

    public UncertaintyCalculator getUncertaintyCalculator() {
        return uncertaintyCalculator;
    }

    public void setUncertaintyCalculator(UncertaintyCalculator uncertaintyCalculator) {
        this.uncertaintyCalculator = uncertaintyCalculator;
    }
}
