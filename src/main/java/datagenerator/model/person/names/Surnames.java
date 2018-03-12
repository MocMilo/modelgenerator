package datagenerator.model.person.names;

import java.util.ArrayList;
import java.util.List;

public class Surnames {
    private List<String> asianSurnames = new ArrayList<>();
    private List<String> northAmericaSurnames = new ArrayList<>();
    private List<String> southAmericaSurnames = new ArrayList<>();
    private List<String> africaNames = new ArrayList<>();
    private List<String> middleEastNames = new ArrayList<>();

    public List<String> getAsianSurnames() {
        return asianSurnames;
    }

    public void setAsianSurnames(List<String> asianSurnames) {
        this.asianSurnames = asianSurnames;
    }

    public List<String> getNorthAmericaSurnames() {
        return northAmericaSurnames;
    }

    public void setNorthAmericaSurnames(List<String> northAmericaSurnames) {
        this.northAmericaSurnames = northAmericaSurnames;
    }

    public List<String> getSouthAmericaSurnames() {
        return southAmericaSurnames;
    }

    public void setSouthAmericaSurnames(List<String> southAmericaSurnames) {
        this.southAmericaSurnames = southAmericaSurnames;
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

