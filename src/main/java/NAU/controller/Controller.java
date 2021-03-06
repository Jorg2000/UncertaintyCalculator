package NAU.controller;

import NAU.model.POJO.TableResultsContainer;
import NAU.controller.utils.MathUtils;
import NAU.model.POJO.TableSingleMeasurementsResultContainer;


import java.util.LinkedList;
import java.util.List;

public class Controller implements IController {

    private MathUtils mc;

    public Controller() {

        mc = new MathUtils();
    }

    public double mean(List<Double> data) {
        if (data.size() > 0) {
            return mc.mean(data);
        } else {
            return 0;
        }
    }

    public double stDevByConstant(double mean) {
        return mc.stanDevByConst(mean);
    }

    public double stDev(List<Double> data) {
        return mc.stanDev(data);
    }

    public double repeatabilityLimit(double stDev) {
        return mc.repeatabilityLimit(stDev);
    }

    public double amplitude(double w1, double w2) {
        return mc.amplitude(w1, w2);
    }

    public TableResultsContainer getResultForData(LinkedList<Double> data) {
        double mean = mean(data);
        double stDev = stDevByConstant(mean);
        double repLim = repeatabilityLimit(stDev);
        return new TableResultsContainer(mean, stDev, repLim);
    }

    public TableSingleMeasurementsResultContainer getResultForSingleMeasuredData(LinkedList<Double> data) {
        double stDev = stDev(data);
        double repLim = repeatabilityLimit(stDev);
        return new TableSingleMeasurementsResultContainer(stDev, repLim);
    }

    public double crushabilityCalc(double sampleMass, double remainMass) {
        return mc.crushability(sampleMass, remainMass);
    }

    public double influenceCoeff(double amount) {
        return mc.influenceCoeffCM1(amount);
    }

    public double constMassUncertainty(double mass) {
        return mc.constMassUncertainty(mass);
    }

    public double influenceCoeffUxCx(double stdUncertainty, double influenceCoeff) {
        return mc.uncertaintyWithInfluenceCoeff(stdUncertainty, influenceCoeff);
    }
}
