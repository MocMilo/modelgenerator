package training.designpatterns.simplefactory.strategies;

import training.designpatterns.simplefactory.result.AnalysisResult;
import training.designpatterns.simplefactory.criteria.Criteria;

public interface AnalysisStrategy<T extends Criteria> {
    AnalysisResult get(T t);

    // Class<T> getType();
}
