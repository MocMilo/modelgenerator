package training.designpatterns.simplefactory;

import training.designpatterns.simplefactory.strategies.CurrencyLoanPricingGenerator;
import training.designpatterns.simplefactory.strategies.PricingGenerator;
import training.designpatterns.simplefactory.strategies.StandardLoanPricingGenerator;
import training.designpatterns.simplefactory.pricing.Pricing;
import training.designpatterns.simplefactory.product.CurrencyLoan;
import training.designpatterns.simplefactory.product.Product;
import training.designpatterns.simplefactory.product.StandardLoan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        // 1. HARDCODED MAP
        // (simulates part of external service that provides Price Generators)

        Map<Class<? extends Product>, PricingGenerator<Product>> mapFromExternalService = new HashMap<>();
        mapFromExternalService.putIfAbsent(CurrencyLoan.class, new CurrencyLoanPricingGenerator());
        mapFromExternalService.putIfAbsent(StandardLoan.class, new StandardLoanPricingGenerator());

        // 2. injecting map to pricing factory (flexible way of "configuring" factory)
        PricingGeneratorFactory pricingFactory = new PricingGeneratorFactory(mapFromExternalService);

        // 3. HARDCODED
        // preparation products to process
        List<Product> products = new ArrayList<>();
        CurrencyLoan currencyLoan = new CurrencyLoan("Speed Currency Loan", 20);
        StandardLoan standardLoan = new StandardLoan("standard loan", LocalDate.of(2000, 10, 10));
        products.add(currencyLoan);
        products.add(standardLoan);

        // 4. EXECUTION USING FACTORY
        // produces factory of PriceGenerators dependent on current Product in list
        products.forEach(x -> {
            Pricing pricingObject = pricingFactory.produce(x);
            System.out.println(pricingObject.getPrice());
        });
    }
}
