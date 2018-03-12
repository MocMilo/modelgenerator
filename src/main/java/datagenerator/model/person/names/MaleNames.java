package datagenerator.model.person.names;

import java.util.ArrayList;
import java.util.List;

public class MaleNames {
    private List<String> asianNames = new ArrayList<>();
    private List<String> northAmericaNemes = new ArrayList<>();
    private List<String> southAmericaNames = new ArrayList<>();
    private List<String> africaNames = new ArrayList<>();
    private List<String> middleEastNames = new ArrayList<>();

    public List<String> getAsianNames() {
        return asianNames;
    }

    public void setAsianNames(List<String> asianNames) {
        this.asianNames = asianNames;
    }

    public List<String> getNorthAmericaNemes() {
        return northAmericaNemes;
    }

    public void setNorthAmericaNemes(List<String> northAmericaNemes) {
        this.northAmericaNemes = northAmericaNemes;
    }

    public List<String> getSouthAmericaNames() {
        return southAmericaNames;
    }

    public void setSouthAmericaNames(List<String> southAmericaNames) {
        this.southAmericaNames = southAmericaNames;
    }

    public List<String> getAfricaNames() {
        return africaNames;
    }

    public void setAfricaNames(List<String> africaNames) {
        this.africaNames = africaNames;
    }

    public List<String> getMiddleEastNames() {
        return middleEastNames;
    }

    public void setMiddleEastNames(List<String> middleEastNames) {
        this.middleEastNames = middleEastNames;
    }
}
