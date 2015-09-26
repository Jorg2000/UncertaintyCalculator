package NAU.model.POJO;


public class TableSingleMeasurementsResultContainer {
    private double stDev;
    private double repLim;

    public TableSingleMeasurementsResultContainer(double stDev, double repLim) {
        this.stDev = stDev;
        this.repLim = repLim;
    }

    public TableSingleMeasurementsResultContainer() {

    }

    public double getStDev() {
        return stDev;
    }

    public void setStDev(double stDev) {
        this.stDev = stDev;
    }

    public double getRepLim() {
        return repLim;
    }

    public void setRepLim(double repLim) {
        this.repLim = repLim;
    }
}
