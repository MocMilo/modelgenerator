package training.designpatterns.listbasedfactory.product;

public class CurrencyLoan implements Product {
    private Integer xyz;
    private String name;

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
