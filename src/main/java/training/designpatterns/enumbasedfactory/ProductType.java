package training.designpatterns.enumbasedfactory;

import training.designpatterns.enumbasedfactory.strategies.CurrencyLoanPricingStrategy;
import training.designpatterns.enumbasedfactory.strategies.PricingStrategy;
import training.designpatterns.enumbasedfactory.strategies.StandardLoanPricingStrategy;

public enum ProductType implements Instanceable {
    ZZZ {
        @Override
        public PricingStrategy getInstance() {
            return new CurrencyLoanPricingStrategy();
        }
    }, PPP {
        @Override
        public PricingStrategy getInstance() {
            return new StandardLoanPricingStrategy();
        }
    };

}
