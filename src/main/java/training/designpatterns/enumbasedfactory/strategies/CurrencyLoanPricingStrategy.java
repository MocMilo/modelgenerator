package training.designpatterns.enumbasedfactory.strategies;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class CurrencyLoanPricingStrategy implements PricingStrategy {
    /**
     * some injected services:
     *
     * @Inject CurrencyService currencyService;
     * @Inject ChargeService chargeService;
     */

    @Override
    public BigDecimal calculatePrice() {
        /**
         * exchangeRate = currencyService.getEUR();
         * chargeService = chargeService.getStandardCharge();
         * ...calculation
         *
         * this BigDecimal can be some composite object with calculation results
         */

        return new BigDecimal("2000.00").setScale(2, RoundingMode.HALF_EVEN);
    }
}
