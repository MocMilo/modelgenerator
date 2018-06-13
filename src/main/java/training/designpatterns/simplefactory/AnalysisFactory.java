package training.designpatterns.simplefactory;

import training.designpatterns.simplefactory.criteria.Criteria;
import training.designpatterns.simplefactory.strategies.AnalysisStrategy;
import training.designpatterns.simplefactory.result.AnalysisResult;

import java.util.HashMap;
import java.util.Map;

public class AnalysisFactory {
    private Map<Class<? extends Criteria>,AnalysisStrategy<Criteria>> knownAnalysis = new HashMap<>();

    // can be @Autowired here. Simulation as if it was injected in here
    public AnalysisFactory(Map<Class<? extends Criteria>, AnalysisStrategy<Criteria>> generatorMap) {
        knownAnalysis.putAll(generatorMap);
    }

    public AnalysisResult produce(Criteria type) {
        return knownAnalysis.get(type.getClass())
                .get(type);   //to ok
    }
}
