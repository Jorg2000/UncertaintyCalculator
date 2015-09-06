package NAU.controller;


import NAU.model.POJO.TableResultsContainer;

import java.util.LinkedList;

/**
 * Created by root on 06.09.2015.
 */
public interface IController {

    double meanAmplitude(LinkedList<Double> data);
    double stDev(double mean);
    double repeatabilityLimit(double stDev);
    double amplitude(double w1, double w2);
    public TableResultsContainer getResultForData(LinkedList<Double> data);

}
