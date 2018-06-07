package training.designpatterns.simplefactory.generators;

import training.designpatterns.simplefactory.product.Product;

import java.math.BigDecimal;

public interface PricingGenerator<T extends Product>  {
 BigDecimal calculatePrice();
   T getType();
}
