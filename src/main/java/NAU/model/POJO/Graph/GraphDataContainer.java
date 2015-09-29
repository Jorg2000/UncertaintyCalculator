package NAU.model.POJO.Graph;

/**
 * Created by SUSLOV on 29.09.2015.
 */
public class GraphDataContainer {
    Double r;
    String mm;

    public GraphDataContainer(Double r, String mm) {
        this.r = r;
        this.mm = mm;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm;
    }
}
