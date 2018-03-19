package training.refactoring.approach2;

import java.util.Optional;

public class BussinesCalculator {

    public static double calculate(Optional<Integer> valueA, Optional<Integer> valueB, int threshold, StringBuilder fetchXml) {

        if (!(valueA.isPresent() && valueB.isPresent()) || !(valueA.get() >= threshold) || !(valueB.get() >= threshold)) {
            double temp = ((double) (valueA.get() * valueB.get()))
                    / threshold * 10
                    / valueA.get();
            return temp;
        } else {
            return 0;
        }


        /*      if (valueA.isPresent() && valueB.isPresent()) {
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
        }*/
    }
}