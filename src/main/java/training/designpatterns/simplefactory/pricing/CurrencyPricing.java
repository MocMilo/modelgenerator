package training.designpatterns.simplefactory.pricing;

import java.math.BigDecimal;

public class CurrencyPricing implements Pricing {

    private BigDecimal price;

    public CurrencyPricing(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
