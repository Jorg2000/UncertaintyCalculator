package NAU.model.POJO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by root on 03.10.2015.
 */
public class SavedDataContainer implements Serializable{
    private List <Double> measurements5_10w1;
    private List <Double> measurements10_20w1;
    private List <Double> measurements20_40w1;
    private List <Double> measurements40_w1;

    private List <Double> measurements5_10w2;
    private List <Double> measurements10_20w2;
    private List <Double> measurements20_40w2;
    private List <Double> measurements40_w2;

    private List <Double> single5_10;
    private List <Double> single10_20;
    private List <Double> single20_40;
    private List <Double> single40_;

    private double stanMassWeightingUncertainty;
    private double sampleMass01;
    private double sampleMass02;
    private double remainderMass01;
    private double remainderMass02;

    private String protNumber;
    private String sampleNumber;

    public SavedDataContainer() {
    }

    public List<Double> getMeasurements5_10w1() {
        return measurements5_10w1;
    }

    public void setMeasurements5_10w1(List<Double> measurements5_10w1) {
        this.measurements5_10w1 = measurements5_10w1;
    }

    public List<Double> getMeasurements10_20w1() {
        return measurements10_20w1;
    }

    public void setMeasurements10_20w1(List<Double> measurements10_20w1) {
        this.measurements10_20w1 = measurements10_20w1;
    }

    public List<Double> getMeasurements20_40w1() {
        return measurements20_40w1;
    }

    public void setMeasurements20_40w1(List<Double> measurements20_40w1) {
        this.measurements20_40w1 = measurements20_40w1;
    }

    public List<Double> getMeasurements40_w1() {
        return measurements40_w1;
    }

    public void setMeasurements40_w1(List<Double> measurements40_w1) {
        this.measurements40_w1 = measurements40_w1;
    }

    public List<Double> getMeasurements5_10w2() {
        return measurements5_10w2;
    }

    public void setMeasurements5_10w2(List<Double> measurements5_10w2) {
        this.measurements5_10w2 = measurements5_10w2;
    }

    public List<Double> getMeasurements10_20w2() {
        return measurements10_20w2;
    }

    public void setMeasurements10_20w2(List<Double> measurements10_20w2) {
        this.measurements10_20w2 = measurements10_20w2;
    }

    public List<Double> getMeasurements20_40w2() {
        return measurements20_40w2;
    }

    public void setMeasurements20_40w2(List<Double> measurements20_40w2) {
        this.measurements20_40w2 = measurements20_40w2;
    }

    public List<Double> getMeasurements40_w2() {
        return measurements40_w2;
    }

    public void setMeasurements40_w2(List<Double> measurements40_w2) {
        this.measurements40_w2 = measurements40_w2;
    }

    public List<Double> getSingle5_10() {
        return single5_10;
    }

    public void setSingle5_10(List<Double> single5_10) {
        this.single5_10 = single5_10;
    }

    public List<Double> getSingle10_20() {
        return single10_20;
    }

    public void setSingle10_20(List<Double> single10_20) {
        this.single10_20 = single10_20;
    }

    public List<Double> getSingle20_40() {
        return single20_40;
    }

    public void setSingle20_40(List<Double> single20_40) {
        this.single20_40 = single20_40;
    }

    public List<Double> getSingle40_() {
        return single40_;
    }

    public void setSingle40_(List<Double> single40_) {
        this.single40_ = single40_;
    }

    public double getStanMassWeightingUncertainty() {
        return stanMassWeightingUncertainty;
    }

    public void setStanMassWeightingUncertainty(double stanMassWeightingUncertainty) {
        this.stanMassWeightingUncertainty = stanMassWeightingUncertainty;
    }

    public double getSampleMass01() {
        return sampleMass01;
    }

    public void setSampleMass01(double sampleMass01) {
        this.sampleMass01 = sampleMass01;
    }

    public double getSampleMass02() {
        return sampleMass02;
    }

    public void setSampleMass02(double sampleMass02) {
        this.sampleMass02 = sampleMass02;
    }

    public double getRemainderMass01() {
        return remainderMass01;
    }

    public void setRemainderMass01(double remainderMass01) {
        this.remainderMass01 = remainderMass01;
    }

    public double getRemainderMass02() {
        return remainderMass02;
    }

    public void setRemainderMass02(double remainderMass02) {
        this.remainderMass02 = remainderMass02;
    }

    public String getProtNumber() {
        return protNumber;
    }

    public void setProtNumber(String protNumber) {
        this.protNumber = protNumber;
    }

    public String getSampleNumber() {
        return sampleNumber;
    }

    public void setSampleNumber(String sampleNumber) {
        this.sampleNumber = sampleNumber;
    }
}
