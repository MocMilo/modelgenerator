package training.designpatterns.simplefactory;

import training.designpatterns.simplefactory.criteria.FundCriteria;
import training.designpatterns.simplefactory.strategies.AnalysisStrategy;
import training.designpatterns.simplefactory.strategies.CurrencyAnalysisStrategy;
import training.designpatterns.simplefactory.strategies.FundAnalysisStrategy;
import training.designpatterns.simplefactory.result.AnalysisResult;
import training.designpatterns.simplefactory.criteria.CurrencyCriteria;
import training.designpatterns.simplefactory.criteria.Criteria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        // 1. HARDCODED MAP
        // (simulates part of external service that provides Price Generators)

        Map<Class<? extends Criteria>, AnalysisStrategy<Criteria>> mapFromExternalService = new HashMap<>();
        mapFromExternalService.putIfAbsent(CurrencyCriteria.class, new CurrencyAnalysisStrategy());
        mapFromExternalService.putIfAbsent(FundCriteria.class, new FundAnalysisStrategy());

        // 2. injecting map to result factory (flexible way of "configuring" factory)
        AnalysisFactory analysisFactory = new AnalysisFactory(mapFromExternalService);

        // 3. HARDCODED
        // preparation products to process
        List<Criteria> criteriaList = new ArrayList<>();
        CurrencyCriteria currencyCriteria = new CurrencyCriteria("Speed Currency Loan", 20);
        FundCriteria fundCriteria = new FundCriteria("standard loan", LocalDate.of(2000, 10, 10));
        criteriaList.add(currencyCriteria);
        criteriaList.add(fundCriteria);

        // 4. EXECUTION USING FACTORY
        // produces factory of PriceGenerators dependent on current Criteria in list
        criteriaList.forEach(x -> {
            AnalysisResult analysisResultObject = analysisFactory.produce(x);

            System.out.println(analysisResultObject.toString());
        });
    }
}
