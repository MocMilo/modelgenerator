package training.designpatterns.simplefactory.generators;

import training.designpatterns.simplefactory.GeneratePrice;

import java.math.BigDecimal;

public abstract class PricingGenerator implements GeneratePrice {
    public abstract BigDecimal calculatePrice();

}
