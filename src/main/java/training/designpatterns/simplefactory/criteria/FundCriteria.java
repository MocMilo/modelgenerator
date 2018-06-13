package training.designpatterns.simplefactory.criteria;

import java.time.LocalDate;

public class FundCriteria implements Criteria {
    private String name;
    private LocalDate expDate;

    public String getName() {
        return name;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public FundCriteria(String name, LocalDate expDate) {
        this.name = name;
        this.expDate = expDate;
    }
}
