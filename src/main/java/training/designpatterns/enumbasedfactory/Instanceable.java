package training.designpatterns.enumbasedfactory;

import training.designpatterns.enumbasedfactory.strategies.PricingStrategy;

public interface Instanceable {
    PricingStrategy getInstance();
}
