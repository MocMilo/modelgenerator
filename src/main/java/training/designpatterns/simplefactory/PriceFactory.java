package training.designpatterns.simplefactory;

import training.designpatterns.simplefactory.generators.PricingGenerator;
import training.designpatterns.simplefactory.product.Product;

import java.util.HashMap;
import java.util.Map;

public class PriceFactory {
    private Map<Class<? extends Product>, PricingGenerator> knownGenerators = new HashMap<>();

    // can be @autowired here. Simulation as if it was injected in here
    public PriceFactory(Map<Class<? extends Product>, PricingGenerator> generatorMap) {
        knownGenerators.putAll(generatorMap);
    }

    public PricingGenerator getPriceGenerator(Class<? extends Product> type) {
        return knownGenerators.get(type);
    }
}
