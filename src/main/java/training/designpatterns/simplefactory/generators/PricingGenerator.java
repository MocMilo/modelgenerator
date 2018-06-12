package training.designpatterns.simplefactory.generators;

import training.designpatterns.simplefactory.product.Product;

import java.math.BigDecimal;

public interface PricingGenerator<T extends Product> {
    /**
     * This interface is a contract to return result
     * from some pricing algorithms
     */
    BigDecimal calculatePrice();
}
