package training.designpatterns.enumbasedfactory;

import training.designpatterns.enumbasedfactory.strategies.PricingStrategy;

public class PricingStrategyFactory {
    public PricingStrategy produce(ProductType type) {
        return type.getInstance();
    }
}
