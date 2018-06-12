package training.designpatterns.simplefactory.strategies;

import training.designpatterns.simplefactory.pricing.Pricing;
import training.designpatterns.simplefactory.pricing.StandardPricing;
import training.designpatterns.simplefactory.product.Product;
import training.designpatterns.simplefactory.product.StandardLoan;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StandardLoanPricingGenerator implements PricingGenerator {

    @Override
    public Class getType() {
        return StandardLoan.class;
    }

    @Override
    public Pricing calculatePrice(Product product) {

        StandardLoan standardLoan = (StandardLoan) product;
        // some logic with product object
        return new StandardPricing(new BigDecimal("1000.00")
                .setScale(2, RoundingMode.HALF_EVEN));
    }
}



