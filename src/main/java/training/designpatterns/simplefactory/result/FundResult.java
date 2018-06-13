package training.designpatterns.simplefactory.result;

import java.util.List;

public class FundResult implements AnalysisResult {


    private List<Integer> indicators;

    public List<Integer> getIndicators() {
        return indicators;
    }

    public FundResult(List<Integer> indicators) {
        this.indicators = indicators;
    }


    @Override
    public String toString() {
        return "FundResult{" +
                "indicators=" + indicators +
                '}';
    }
}
