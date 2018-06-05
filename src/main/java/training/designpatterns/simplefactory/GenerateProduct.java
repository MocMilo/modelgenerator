package training.designpatterns.simplefactory;

import java.math.BigDecimal;

public interface GenerateProduct {
        BigDecimal calculatePrice();
        String generateAgreement();
}
