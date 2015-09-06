package NAU.controller;


import NAU.model.POJO.TableResultsContainer;
import NAU.model.POJO.TableSingleMeasurementsResultContainer;

import java.util.LinkedList;

/**
 * Created by root on 06.09.2015.
 */
public interface IController {

    double meanAmplitude(LinkedList<Double> data);
    double stDevByConstant(double mean);
    double stDev(LinkedList<Double> data);
    double repeatabilityLimit(double stDev);
    double amplitude(double w1, double w2);
    TableResultsContainer getResultForData(LinkedList<Double> data);
    TableSingleMeasurementsResultContainer getResultForSingleMeasuredData(LinkedList<Double> data);


}
