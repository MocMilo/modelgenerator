package training.designpatterns.simplefactory.product;

import java.time.LocalDate;

public class StandardLoan extends Product {
    private String name;
    private LocalDate expDate;

    public String getName() {
        return name;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public StandardLoan(String name, LocalDate expDate) {
        this.name = name;
        this.expDate = expDate;
    }
}
