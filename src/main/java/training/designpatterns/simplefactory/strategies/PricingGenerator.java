package training.designpatterns.simplefactory.strategies;

import training.designpatterns.simplefactory.pricing.Pricing;
import training.designpatterns.simplefactory.product.Product;

public interface PricingGenerator<T extends Product> {
    Pricing calculatePrice(T t);
    Class<T> getType();
}
