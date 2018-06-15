package training.refactoring;

import java.util.Optional;

public class BussinessCalculatorBeforeRefactoring {

    public static double calculatePrice(Optional<Integer> valueA, Optional<Integer> valueB, int threshold, StringBuilder fetchXml) {
        if (valueA.isPresent() && valueB.isPresent()) {
            if (valueA.get() >= threshold) {
                if (valueB.get() >= threshold) {
                    double temp = ((double) (valueA.get() * valueB.get()))
                            / threshold * 10
                            / valueA.get();
                    // (a*b)/t/a
                    return temp;
                } else {

                    return 0;
                }
            } else {

                return 0;
            }
        } else {

            return 0;
        }
    }
}
