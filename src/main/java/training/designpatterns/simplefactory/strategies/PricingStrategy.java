package training.designpatterns.simplefactory.strategies;

import training.designpatterns.simplefactory.model.product.Product;

import java.math.BigDecimal;

public interface PricingStrategy<T extends Product> {
    /**
     * This interface is a contract to return result
     * from some pricing algorithms
     */
    BigDecimal calculatePrice();
}
