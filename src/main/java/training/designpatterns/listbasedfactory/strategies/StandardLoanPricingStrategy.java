package training.designpatterns.listbasedfactory.strategies;

import training.designpatterns.listbasedfactory.product.Product;
import training.designpatterns.listbasedfactory.product.StandardLoan;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StandardLoanPricingStrategy implements PricingStrategy {

    @Override
    public Class getType() {
        return  StandardLoan.class;
    }

    /**
     * @Inject
     * ChargeService chargeService;
     */

    @Override
    public BigDecimal calculatePrice() {
        /**
         * chargeService = chargeService.getStandardCharge();
         * ...calculation
         */

        return new BigDecimal("1000.00").setScale(2, RoundingMode.HALF_EVEN);
    }
}

