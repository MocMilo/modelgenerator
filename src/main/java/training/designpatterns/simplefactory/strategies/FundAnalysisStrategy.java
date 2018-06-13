package training.designpatterns.simplefactory.strategies;

import training.designpatterns.simplefactory.result.AnalysisResult;
import training.designpatterns.simplefactory.result.FundResult;
import training.designpatterns.simplefactory.criteria.Criteria;
import training.designpatterns.simplefactory.criteria.FundCriteria;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class FundAnalysisStrategy implements AnalysisStrategy {

    @Override
    public AnalysisResult get(Criteria criteria) {

        FundCriteria fundCriteria = (FundCriteria) criteria;
        // some logic with criteria object
        return new FundResult(Arrays.asList(1,2,3,4));
    }

       /* @Override
    public Class getType() {
        return FundCriteria.class;
    }*/
}



