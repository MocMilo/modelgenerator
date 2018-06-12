package training.designpatterns.simplefactory.strategies;

import training.designpatterns.simplefactory.pricing.CurrencyPricing;
import training.designpatterns.simplefactory.product.CurrencyLoan;
import training.designpatterns.simplefactory.product.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class CurrencyLoanPricingGenerator implements PricingGenerator {

    @Override
    public CurrencyPricing calculatePrice(Product product) {
        CurrencyLoan currencyLoan = (CurrencyLoan) product;
        // some operation on product
        // return some composite instead of BigDecimal
        BigDecimal price = new BigDecimal("2000.00").setScale(2, RoundingMode.HALF_EVEN);
        return new CurrencyPricing(price);
    }

    @Override
    public Class getType() {
        return CurrencyLoan.class;
    }
}
