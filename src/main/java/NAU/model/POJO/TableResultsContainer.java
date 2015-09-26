package NAU.model.POJO;

public class TableResultsContainer {

    private double ampMean;
    private double stDev;
    private double repLim;

    public TableResultsContainer(double ampMean, double stDev, double repLim) {
        this.ampMean = ampMean;
        this.stDev = stDev;
        this.repLim = repLim;
    }

    public TableResultsContainer() {

    }

    public double getAmpMean() {
        return ampMean;
    }

    public void setAmpMean(double ampMean) {
        this.ampMean = ampMean;
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
