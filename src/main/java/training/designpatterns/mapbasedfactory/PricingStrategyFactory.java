package training.designpatterns.mapbasedfactory;

import training.designpatterns.mapbasedfactory.product.Product;
import training.designpatterns.mapbasedfactory.strategies.PricingStrategy;

import java.util.HashMap;
import java.util.Map;

public class PricingStrategyFactory {
    private Map<Class<? extends Product>, PricingStrategy> knownStrategies = new HashMap<>();
    /**
     * this map maps every class that implements Product Interface to current PricingStrategy Interface
     * this map can be @Autowired here (simulation as if this map was injected here from bean)
     */

    public PricingStrategyFactory(Map<Class<? extends Product>, PricingStrategy> strategiesMap) {
        knownStrategies.putAll(strategiesMap);
    }

    public PricingStrategy produce(Class<? extends Product> type) {
        return knownStrategies.get(type);
    }
}
