package training.designpatterns.enumbasedfactory.strategies;

import java.math.BigDecimal;

public interface PricingStrategy{
    /**
     * This interface is a contract to return result
     * from some pricing algorithms
     */
    BigDecimal calculatePrice();
}
