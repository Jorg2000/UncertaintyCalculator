package NAU.model.POJO;

/**
 * Created by root on 27.09.2015.
 */
public class MeasurementDataContainer {
    String number;
    String w1;
    String w2;
    String diff;

    public MeasurementDataContainer(String number, String w1, String w2, String diff) {
        this.number = number;
        this.w1 = w1;
        this.w2 = w2;
        this.diff = diff;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getW1() {
        return w1;
    }

    public void setW1(String w1) {
        this.w1 = w1;
    }

    public String getW2() {
        return w2;
    }

    public void setW2(String w2) {
        this.w2 = w2;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }
}
