package training.designpatterns.simplefactory.generators;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StandardLoanGenerator extends ProductGenerator {

    // @Inject
    // ChargeService chargeService;

    @Override
    public BigDecimal calculatePrice() {
        // chargeService = chargeService.getStandardCharge();
        // ...calculation
        return new BigDecimal("1000.00").setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public String generateAgreement() {
        // agrement generating...

        return "Agreement content for StandartLoan";
    }
}

