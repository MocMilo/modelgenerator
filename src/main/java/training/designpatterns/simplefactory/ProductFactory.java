package training.designpatterns.simplefactory;

import training.designpatterns.simplefactory.generators.ProductGenerator;

public class ProductFactory {

    public static GenerateProduct getProductGenerator(ProductGenerator productGenerator){
        return productGenerator;
    }
}
