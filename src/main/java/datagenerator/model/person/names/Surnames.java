package datagenerator.model.person.names;

import java.util.ArrayList;
import java.util.List;

public class Surnames {
    List<String> asianSurnames = new ArrayList<>();
    List<String> northAmericaSurnames = new ArrayList<>();
    List<String> southAmericaSurnames = new ArrayList<>();

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

}

