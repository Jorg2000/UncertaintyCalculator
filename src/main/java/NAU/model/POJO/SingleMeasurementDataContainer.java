package NAU.model.POJO;

/**
 * Created by root on 28.09.2015.
 */
public class SingleMeasurementDataContainer {
    String number;
    String w5_10;
    String w10_20;
    String w20_40;
    String w40_;

    public SingleMeasurementDataContainer(String number, String w5_10, String w10_20, String w20_40, String w40_) {
        this.number = number;
        this.w5_10 = w5_10;
        this.w10_20 = w10_20;
        this.w20_40 = w20_40;
        this.w40_ = w40_;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getW5_10() {
        return w5_10;
    }

    public void setW5_10(String w5_10) {
        this.w5_10 = w5_10;
    }

    public String getW10_20() {
        return w10_20;
    }

    public void setW10_20(String w10_20) {
        this.w10_20 = w10_20;
    }

    public String getW20_40() {
        return w20_40;
    }

    public void setW20_40(String w20_40) {
        this.w20_40 = w20_40;
    }

    public String getW40_() {
        return w40_;
    }

    public void setW40_(String w40_) {
        this.w40_ = w40_;
    }
}
