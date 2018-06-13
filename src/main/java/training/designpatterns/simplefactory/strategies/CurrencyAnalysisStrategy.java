package training.designpatterns.simplefactory.strategies;

import training.designpatterns.simplefactory.result.CurrencyResult;
import training.designpatterns.simplefactory.criteria.CurrencyCriteria;
import training.designpatterns.simplefactory.criteria.Criteria;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class CurrencyAnalysisStrategy implements AnalysisStrategy {

    @Override
    public CurrencyResult get(Criteria criteria) {
        CurrencyCriteria currencyCriteria = (CurrencyCriteria) criteria;
        // some operation on criteria
        // return some composite instead of BigDecimal
        BigDecimal price = new BigDecimal("2000.00").setScale(2, RoundingMode.HALF_EVEN);
        return new CurrencyResult(price);
    }

/*    @Override
    public Class getType() {
        return CurrencyCriteria.class;
    }*/
}
