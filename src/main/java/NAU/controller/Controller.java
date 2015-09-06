package NAU.controller;

import NAU.model.POJO.TableResultsContainer;
import NAU.controller.utils.UncertaintyCalculator;
import NAU.model.POJO.TableSingleMeasurementsResultContainer;


import java.util.LinkedList;

public class Controller implements IController {


    private UncertaintyCalculator mc;

    public Controller() {

        mc = new UncertaintyCalculator();
    }

    public double meanAmplitude(LinkedList<Double> data) {
        if (data.size() > 0) {
            return mc.mean(data);
        }
        else {
            return 0;
        }
    }

    public double stDevByConstant(double mean) {
        return mc.stanDevByConst(mean);
    }

    public double stDev(LinkedList<Double> data) {
        return mc.stanDev(data);
    }

    public double repeatabilityLimit(double stDev) {
        return mc.repeatabilityLimit(stDev);
    }

    public double amplitude(double w1, double w2) {
        return mc.amplitude(w1, w2);
    }

    public TableResultsContainer getResultForData(LinkedList<Double> data) {
        double mean = meanAmplitude(data);
        double stDev = stDevByConstant(mean);
        double repLim = repeatabilityLimit(stDev);
        return new TableResultsContainer(mean,stDev,repLim);
    }

    public TableSingleMeasurementsResultContainer getResultForSingleMeasuredData(LinkedList<Double> data) {
        double stDev = stDev(data);
        double repLim = repeatabilityLimit(stDev);
        return new TableSingleMeasurementsResultContainer(stDev,repLim);
    }


}
