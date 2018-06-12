package training.smalltasks.primenumbers;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

    public List<Integer> findPrimeNumbers(int target) {
        List<Integer> list = new ArrayList<>();
        int divisor = 2;
        while (target > 1) {
            while (target % divisor == 0) {
                list.add(divisor);
                target = target / divisor;
            }
            ++divisor;
        }
        return list;
    }

    public List<Integer> findPrimeNumbersComment(int target) {
        List<Integer> list = new ArrayList<>();
        int divisor = 2;                          // smallest divisor > 1
        while (target > 1) {
            while (target % divisor == 0) {    // division without fraction
                list.add(divisor);
                target = target / divisor;    // when parameter == 1, exits outer while loop

                System.out.println("parameter:" + target);
            }
            System.out.println("divisor try:" + divisor);
            ++divisor;
        }
        return list;
    }

    public static void main(String[] args) {
        PrimeNumbers primeNumbers = new PrimeNumbers();
        List<Integer> list = primeNumbers.findPrimeNumbers(57);
        System.out.println("result");
        list.forEach(System.out::println);
    }

}
