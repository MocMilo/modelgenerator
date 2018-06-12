package training.smalltasks.primetask;

import java.util.ArrayList;
import java.util.List;

public class PrimeFinder {

/*    public List<Integer> getNormalNumberFactorize(){



    }*/

    public List<Integer> getPrimeDividorsForNumber(Integer checkedNumber) {
        List<Integer> dividors = this.getDividors(checkedNumber);
        List<Integer> primes = new ArrayList<>();
        dividors.size();
        dividors.forEach(x -> {
            if (isPrime(x)){
                primes.add(x);
            }
        });
        return primes;
    }

    public List<Integer> getDividors(Integer checkedNumber) {
        List<Integer> dividors = new ArrayList<>();
       for (int i = 2; i <= (int) Math.sqrt(checkedNumber) + 1 ; i++) {
            if (checkedNumber % i == 0) {
                dividors.add(i);
            }
        }
       // dividors.add(checkedNumber);
        return dividors;
    }

    public boolean isPrime(Integer number) {
        for (int i = 2; i < number-1; i++) {
            if (number % i == 0)
            return false;
        }
        return true;
    }
}
