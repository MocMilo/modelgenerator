package training.refactoring.approach1;

import java.util.Optional;

public class BussinesCalculator {

    public static final int CONST_10 = 10;

    public static double calculate(Optional<Integer> valueA, Optional<Integer> valueB,
                                   int threshold, StringBuilder fetchXml) {
        if (!(valueA.isPresent() && valueB.isPresent()) || !(valueA.get() >= threshold) || !(valueB.get() >= threshold)) {
            return 0;
        } else {
            double temp = ((double) (valueA.get() * valueB.get()))
                    / threshold * CONST_10
                    / valueA.get();
            return temp;
        }
    }
}
