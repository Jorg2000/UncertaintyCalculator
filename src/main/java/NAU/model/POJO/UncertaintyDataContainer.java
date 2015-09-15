package NAU.model.POJO;

/**
 * Created by SUSLOV on 15.09.2015.
 */
public class UncertaintyDataContainer {
    private double stanMassWeightingUncertainty;
    private double meanSampleMass;
    private double meanRemainMass;
    private double maxDifferenceBetweenResults;

    public UncertaintyDataContainer() {
        this.stanMassWeightingUncertainty = 0;
        this.meanSampleMass = 0;
        this.meanRemainMass = 0;
        this.maxDifferenceBetweenResults = 0;
    }

    public UncertaintyDataContainer(double stanMassWeightingUncertainty, double meanSampleMass, double meanRemainMass, double maxDifferenceBetweenResults) {
        this.stanMassWeightingUncertainty = stanMassWeightingUncertainty;
        this.meanSampleMass = meanSampleMass;
        this.meanRemainMass = meanRemainMass;
        this.maxDifferenceBetweenResults = maxDifferenceBetweenResults;
    }

    public double getStanMassWeightingUncertainty() {
        return stanMassWeightingUncertainty;
    }

    public void setStanMassWeightingUncertainty(double stanMassWeightingUncertainty) {
        this.stanMassWeightingUncertainty = stanMassWeightingUncertainty;
    }

    public double getMeanSampleMass() {
        return meanSampleMass;
    }

    public void setMeanSampleMass(double meanSampleMass) {
        this.meanSampleMass = meanSampleMass;
    }

    public double getMeanRemainMass() {
        return meanRemainMass;
    }

    public void setMeanRemainMass(double meanRemainMass) {
        this.meanRemainMass = meanRemainMass;
    }

    public double getMaxDifferenceBetweenResults() {
        return maxDifferenceBetweenResults;
    }

    public void setMaxDifferenceBetweenResults(double maxDifferenceBetweenResults) {
        this.maxDifferenceBetweenResults = maxDifferenceBetweenResults;
    }
}
