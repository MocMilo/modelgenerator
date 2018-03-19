package training.refactoring.approach1;

import java.util.Optional;

public class BussinesCalculatorWithBug {

    private static final int CONST = 10;

    public static double calculate(Optional<Integer> valueA, Optional<Integer> valueB,
                                   int threshold, StringBuilder fetchXml) {

        if (!(valueA.isPresent() && valueB.isPresent()) || !((valueA.get() >= threshold)) || !(valueB.get() >= threshold)) {
            fetchXml.append("");
            return 0;
        } else {
            fetchXML(valueA, valueB, fetchXml);

            double temp = ((double) (valueA.get() * valueB.get()))
                    / threshold * CONST
                    / valueA.get();
            return temp;
        }
    }

    private static void fetchXML(Optional<Integer> valueA, Optional<Integer> valueB,
                          StringBuilder fetchXml){
        fetchXml.append("<valueA>".concat(valueA.toString()).concat("</valueA>"));
        fetchXml.append("<valueB>".concat(valueB.toString()).concat("</valueB>"));
        fetchXml.append("</fetch>");
    }
}

