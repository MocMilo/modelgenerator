package training.designpatterns.simplefactory;

import training.designpatterns.simplefactory.strategies.PricingStrategy;
import training.designpatterns.simplefactory.model.product.Product;

import java.util.HashMap;
import java.util.Map;

public class PricingStrategyFactory {
    private Map<Class<? extends Product>, PricingStrategy<Product>> knownGenerators = new HashMap<>();

    /**
     * this map maps every class that implements Product Interface to current PricingStrategy Interface
     * this map  can be @autowired here.
     * Simulation as if this map was injected in here from bean
     */
    public PricingStrategyFactory(Map<Class<? extends Product>, PricingStrategy<Product>> generatorMap) {
        knownGenerators.putAll(generatorMap);
    }

    public PricingStrategy getPriceGenerator(Class<? extends Product> type) {
        return knownGenerators.get(type);
    }
}
