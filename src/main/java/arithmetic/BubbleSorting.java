package arithmetic;

import java.util.Arrays;

public class BubbleSorting {

    public static void main(String[] args) {

        String[] unsorted = {"d", "a", "e", "b", "c", "ze", "zf", "g", "h", "i", "johny", "bravo"};
        String[] sorted = sortStringArray(unsorted);
        Arrays.stream(sorted).forEach(System.out::println);
    }

    public static String[] sortStringArray(String[] unsorted) {
        for (int o = 1; o < unsorted.length; o++) {
            for (int i = 1; i < unsorted.length; i++) {
                if ((unsorted[i - 1].compareTo(unsorted[i])) == 0) {
                    System.out.println("no action");
                }
                if (unsorted[i - 1].compareTo(unsorted[i]) > 0) {
                    // swap places
                    String temp = unsorted[i];
                    String temp2 = unsorted[i - 1];
                    unsorted[i - 1] = temp;
                    unsorted[i] = temp2;

                    System.out.println("swapping: " + temp2 + " " + temp);
                    // System.out.println("swapped: " + unsorted[i - 1] + " " + unsorted[i]);
                }
            }
        }
        return unsorted;
    }
}
