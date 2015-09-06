package NAU.model.POJO;

/**
 * Created by root on 06.09.2015.
 */
public class TableSingleMeasurementsResultContainer {
    double stDev;
    double repLim;

    public TableSingleMeasurementsResultContainer(double stDev, double repLim) {
        this.stDev = stDev;
        this.repLim = repLim;
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
