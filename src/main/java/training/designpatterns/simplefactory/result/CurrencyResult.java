package training.designpatterns.simplefactory.result;

import java.math.BigDecimal;

public class CurrencyResult implements AnalysisResult {

    private BigDecimal revenue;

    public BigDecimal getRevenue() {
        return revenue;
    }

    public CurrencyResult(BigDecimal revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "CurrencyResult{" +
                "revenue=" + revenue +
                '}';
    }
}
