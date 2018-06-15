package training.designpatterns.listbasedfactory.strategies;

import training.designpatterns.listbasedfactory.product.Product;

import java.math.BigDecimal;

public interface PricingStrategy {
    /**
     * This interface is a contract to return result
     * from some pricing algorithms
     */
    BigDecimal calculatePrice();

    Class<? extends Product> getType();
}
