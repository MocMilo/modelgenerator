package training.designpatterns.simplefactory;

import training.designpatterns.simplefactory.strategies.PricingGenerator;
import training.designpatterns.simplefactory.pricing.Pricing;
import training.designpatterns.simplefactory.product.Product;

import java.util.HashMap;
import java.util.Map;

public class PricingGeneratorFactory {
    private Map<Class<? extends Product>,PricingGenerator<Product>> knownGenerators = new HashMap<>();

    // can be @autowired here. Simulation as if it was injected in here
    public PricingGeneratorFactory(Map<Class<? extends Product>, PricingGenerator<Product>> generatorMap) {
        knownGenerators.putAll(generatorMap);
    }

    public Pricing produce(Product type) {
        return knownGenerators.get(type.getClass())
                .calculatePrice(type);
    }
}
