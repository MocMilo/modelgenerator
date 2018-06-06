package training.designpatterns.simplefactory;

import training.designpatterns.simplefactory.generators.PricingGenerator;
import training.designpatterns.simplefactory.product.Product;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PriceFactory {
    private Map<Class<? extends Product>, PricingGenerator> knownGenerators = new HashMap<>();

    // can be @autowired here , to simulate injected in App
    public PriceFactory(Map<Class<? extends Product>, PricingGenerator> generatorMap){

       /// Collections.copy(knownGenerators, generatorMap); ///TODO

        generatorMap.forEach((k, v)-> {
                knownGenerators.putIfAbsent(k,v);
        });
    }

    public PricingGenerator getPriceGenerator(Class<? extends Product> type){
            return knownGenerators.get(type);
    }
}
