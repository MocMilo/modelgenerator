package training.designpatterns.listbasedfactory;

import training.designpatterns.listbasedfactory.product.Product;
import training.designpatterns.listbasedfactory.strategies.PricingStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PricingStrategyFactory {
    private Map<Class<? extends Product>, PricingStrategy> knownStrategies = new HashMap<>();
    /**
     * this map maps every class that implements Product Interface to current PricingStrategy Interface
     * this map can be @Autowired here (simulation as if this map was injected here from bean)
     */

    public PricingStrategyFactory(List<PricingStrategy> strategies) {
        strategies.forEach( x -> knownStrategies.put(x.getType(), x));
    }

    public PricingStrategy produce(Class<? extends Product> type) {
        return knownStrategies.get(type);
    }
}
