package training.designpatterns.simplefactory.generators;

import java.math.BigDecimal;

public interface PricingGenerator  {
   public abstract BigDecimal calculatePrice();
}
