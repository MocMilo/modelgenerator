package training.designpatterns.listbasedfactory;


import training.designpatterns.listbasedfactory.product.CurrencyLoan;
import training.designpatterns.listbasedfactory.product.Product;
import training.designpatterns.listbasedfactory.product.StandardLoan;
import training.designpatterns.listbasedfactory.strategies.CurrencyLoanPricingStrategy;
import training.designpatterns.listbasedfactory.strategies.PricingStrategy;
import training.designpatterns.listbasedfactory.strategies.StandardLoanPricingStrategy;

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
         * 1. HARDCODED LIST
         * (simulates part of external service that provides "Pricing algorithms as strategies")
         */

        List<PricingStrategy> pricingStrategies = new ArrayList<>();
        pricingStrategies.add(new CurrencyLoanPricingStrategy());
        pricingStrategies.add(new StandardLoanPricingStrategy());

        /**
         * 2. Injecting List to factory
         *    Factory doesn't have hardcoded map, so factory doesn't have to be changed
         *    when adding extra strategies (flexible way of "configuring" factory)
         */
        PricingStrategyFactory pricingStrategyFactory = new PricingStrategyFactory(pricingStrategies);

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
         * foreach Product in list PricingStrategyFactory produces strategy (separate algorithm)
         * to get pricing result
         */
        products.forEach(x -> {
            PricingStrategy pricingStrategy = pricingStrategyFactory.produce(x.getClass());
            System.out.println("product" + x.getClass() + "Pricing Strategy result:"
                    + pricingStrategy.calculatePrice());
        });
    }
}
