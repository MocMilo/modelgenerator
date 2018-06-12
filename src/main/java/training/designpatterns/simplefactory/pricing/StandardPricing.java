package training.designpatterns.simplefactory.pricing;

import java.math.BigDecimal;

public class StandardPricing implements Pricing {

    private BigDecimal price;

    public StandardPricing(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
