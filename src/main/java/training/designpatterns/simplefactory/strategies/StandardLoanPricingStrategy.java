package training.designpatterns.simplefactory.strategies;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StandardLoanPricingStrategy implements PricingStrategy {

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

