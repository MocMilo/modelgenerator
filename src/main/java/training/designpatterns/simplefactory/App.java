package training.designpatterns.simplefactory;

import training.designpatterns.simplefactory.strategies.CurrencyLoanPricingStrategy;
import training.designpatterns.simplefactory.strategies.PricingStrategy;
import training.designpatterns.simplefactory.strategies.StandardLoanPricingStrategy;
import training.designpatterns.simplefactory.model.product.CurrencyLoan;
import training.designpatterns.simplefactory.model.product.Product;
import training.designpatterns.simplefactory.model.product.StandardLoan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        /**
         *  inspired by:
         *  https://dzone.com/articles/design-patterns-the-strategy-and-factory-patterns
         */

        /**
         * 1. HARDCODED MAP
         * (simulates part of external service that provides "Pricing Generators")
         */
        Map<Class<? extends Product>, PricingStrategy<Product>> mapFromExternalService = new HashMap<>();
        mapFromExternalService.putIfAbsent(CurrencyLoan.class, new CurrencyLoanPricingStrategy());
        mapFromExternalService.putIfAbsent(StandardLoan.class, new StandardLoanPricingStrategy());

        /**
         * 2. injecting map to pricing factory (flexible way of "configuring" factory)
         */
        PricingStrategyFactory pricingStrategyFactory = new PricingStrategyFactory(mapFromExternalService);

        /**
         *  3. HARDCODED
         *  preparation products to process
         */
        List<Product> products = new ArrayList<>();
        CurrencyLoan currencyLoan = new CurrencyLoan("Speed Currency Loan", 20);
        StandardLoan standardLoan = new StandardLoan("standard loan", LocalDate.of(2000, 10, 10));
        products.add(currencyLoan);
        products.add(standardLoan);

        /**
         * 4. EXECUTION USING FACTORY
         * produces factory of PriceGenerators dependent on current Product in list
         */
        products.forEach(x -> {
            PricingStrategy pricingGenerator = pricingStrategyFactory.getPriceGenerator(x.getClass());
            System.out.println(pricingGenerator.calculatePrice());
        });
    }
}
