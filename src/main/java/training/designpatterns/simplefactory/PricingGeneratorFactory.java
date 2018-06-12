package training.designpatterns.simplefactory;

import training.designpatterns.simplefactory.generators.PricingGenerator;
import training.designpatterns.simplefactory.product.Product;

import java.util.HashMap;
import java.util.Map;

public class PricingGeneratorFactory {
    private Map<Class<? extends Product>, PricingGenerator<Product>> knownGenerators = new HashMap<>();

    /**
     * this map maps every class that implements Product Interface to current PricingGenerator Interface
     * this map  can be @autowired here.
     * Simulation as if this map was injected in here from bean
     */


    public PricingGeneratorFactory(Map<Class<? extends Product>, PricingGenerator<Product>> generatorMap) {
        knownGenerators.putAll(generatorMap);
    }

    public PricingGenerator getPriceGenerator(Class<? extends Product> type) {
        return knownGenerators.get(type);
    }
}
