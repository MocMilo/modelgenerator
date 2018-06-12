package training.refactoring;

import java.util.Optional;

public class BussinessCalculatorBeforeRefactoring {

    /*public static double calculatePrice(Optional<Integer> valueA, Optional<Integer> valueB, int threshold, StringBuilder fetchXml) {
        if (valueA.isPresent() && valueB.isPresent()) {
            if (valueA.get() >= threshold) {
                fetchXml = new StringBuilder("<fetch>");
                fetchXml.append("<valueA>" + valueA.toString() + "</valueA>");
                if (valueB.get() >= threshold) {
                    fetchXml.append("<valueB>" + valueB.toString() + "</valueB>");
                    double temp = ((double) (valueA.get() * valueB.get()))
                            / threshold * 10
                            / valueA.get();

                    // (a*b)/t/a

                    fetchXml.append("</fetch>");
                    return temp;
                } else {
                    fetchXml.append("</fetch>");
                    return 0;
                }
            } else {
                fetchXml.append("");
                return 0;
            }
        } else {
            fetchXml.append("");
            return 0;
        }
    }*/
}
