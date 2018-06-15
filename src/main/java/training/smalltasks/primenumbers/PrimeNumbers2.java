package training.smalltasks.primenumbers;

import java.util.List;


import java.util.ArrayList;

public class PrimeNumbers2 {


    public static void main(String[] args) {

        findPrimes(5).forEach(System.out::println);

        /*
         *  60 / 2
         *  30 / 2
         *  15 / 3
         *  5  / 5
         *
         *  1 / 1
         *  1
         * */


    }

    public static List<Integer> findPrimes(Integer number) {
        List<Integer> list = new ArrayList<>();
        Integer divisor = 2;
        while (number > 1) {
            while (number % divisor == 0) {
                list.add(divisor);
                number = number / divisor;
            }
            ++divisor;
        }
        return list;
    }

}
