package training.designpatterns.mapbasedfactory.product;

import java.time.LocalDate;

public class StandardLoan implements Product {
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
