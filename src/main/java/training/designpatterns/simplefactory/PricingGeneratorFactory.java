package training.designpatterns.simplefactory;

import training.designpatterns.simplefactory.generators.PricingGenerator;
import training.designpatterns.simplefactory.product.Product;

import java.util.HashMap;
import java.util.Map;

public class PricingGeneratorFactory {
    /*private Map<Class<? extends Product>, PricingGenerator> knownGenerators = new HashMap<>();

    // can be @autowired here. Simulation as if it was injected in here
    public PricingGeneratorFactory(Map<Class<? extends Product>, List<> PricingGenerator> generatorMap) {
        knownGenerators.putAll(generatorMap);
    }

    public PricingGenerator getPriceGenerator(Class<? extends Product> type) {
        return knownGenerators.get(type);
    }*/
}
