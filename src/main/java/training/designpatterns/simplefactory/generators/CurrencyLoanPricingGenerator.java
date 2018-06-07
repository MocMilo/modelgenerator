package training.designpatterns.simplefactory.generators;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class CurrencyLoanPricingGenerator implements PricingGenerator {

    // getType()  ENUM   ....class

    // to tworząc przekazując

    // @Inject
    // CurrencyService currencyService;
    // @Inject
    // ChargeService chargeService;

    @Override
    public BigDecimal calculatePrice() {
        // exchangeRate = currencyService.getEUR();
        // chargeService = chargeService.getStandardCharge();
        // ...calculation
        return new BigDecimal("2000.00").setScale(2, RoundingMode.HALF_EVEN);
    }

}
