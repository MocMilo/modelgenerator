package training.designpatterns.simplefactory;

import training.designpatterns.simplefactory.generators.CurrencyLoanGenerator;
import training.designpatterns.simplefactory.generators.ProductGenerator;
import training.designpatterns.simplefactory.generators.StandardLoanGenerator;

public class App {
    public static void main(String[] args) {
        ProductGenerator standardLoanGenerator = new StandardLoanGenerator();
        ProductGenerator currencyLoanGenerator = new CurrencyLoanGenerator();

        // Factory doesn't know what concrete generator (extending ProductGenerator)
        // it will receive as input at runtime

        // Factory doesn't return concrete Type of product generator but
        // it has access to it's methods, and can execute those methods.

        GenerateProduct s = ProductFactory.getProductGenerator(standardLoanGenerator);
        System.out.println(s.calculatePrice());
        System.out.println(s.generateAgreement());

        GenerateProduct c = ProductFactory.getProductGenerator(currencyLoanGenerator);
        System.out.println(c.calculatePrice());
        System.out.println(c.generateAgreement());
    }
}
