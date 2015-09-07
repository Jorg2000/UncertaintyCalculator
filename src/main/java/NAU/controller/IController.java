package NAU.controller;


import NAU.model.POJO.TableResultsContainer;
import NAU.model.POJO.TableSingleMeasurementsResultContainer;

import java.util.LinkedList;
import java.util.List;


public interface IController {

    double meanAmplitude(List<Double> data);
    double stDevByConstant(double mean);
    double stDev(List<Double> data);
    double repeatabilityLimit(double stDev);
    double amplitude(double w1, double w2);
    TableResultsContainer getResultForData(LinkedList<Double> data);
    TableSingleMeasurementsResultContainer getResultForSingleMeasuredData(LinkedList<Double> data);


}
