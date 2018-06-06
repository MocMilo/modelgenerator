package training.designpatterns.simplefactory.product;

public class CurrencyLoan extends Product {
    private String name;
    private Integer xyz;

    public String getName() {
        return name;
    }

    public Integer getXyz() {
        return xyz;
    }

    public CurrencyLoan(String name, Integer xyz) {
        this.name = name;
        this.xyz = xyz;
    }
}
