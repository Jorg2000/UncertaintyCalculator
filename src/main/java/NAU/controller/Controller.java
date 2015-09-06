package NAU.controller;

import NAU.model.POJO.TableResultsContainer;
import NAU.controller.utils.UncertaintyCalculator;


import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedList;

public class Controller implements IController {

    private DecimalFormat df;
    private DecimalFormatSymbols decimalFormatSymbols;
    UncertaintyCalculator mc;

    public Controller() {
        df = new DecimalFormat("0.00");
        decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator(',');
        df.setRoundingMode(RoundingMode.HALF_UP);
        df.setDecimalFormatSymbols(decimalFormatSymbols);
        mc = new UncertaintyCalculator();
    }

    public double meanAmplitude(LinkedList<Double> data) {
        if (data.size() > 0) {
            return mc.meanAmplitude(data);
        }
        else {
            return 0;
        }
    }

    public double stDev(double mean) {
        return mc.stanDev(mean);
    }

    public double repeatabilityLimit(double stDev) {
        return mc.repeatabilityLimit(stDev);
    }

    public double amplitude(double w1, double w2) {
        return mc.amplitude(w1, w2);
    }

    public TableResultsContainer getResultForData(LinkedList<Double> data) {
        double mean = meanAmplitude(data);
        double stDev = stDev(mean);
        double repLim = repeatabilityLimit(stDev);
        return new TableResultsContainer(mean,stDev,repLim);
    }

}
