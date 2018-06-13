package training.designpatterns.simplefactory.criteria;

public class CurrencyCriteria implements Criteria {
    private Integer xyz;
    private String name;

    public String getName() {
        return name;
    }

    public Integer getXyz() {
        return xyz;
    }

    public CurrencyCriteria(String name, Integer xyz) {
        this.name = name;
        this.xyz = xyz;
    }
}
