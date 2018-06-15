package training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringBubbleSort {


    public static void main(String[] args) {

        String[] unsorted = {"z", "b", "d", "e", "f", "g", "h", "y"};

        Arrays.stream(sort(unsorted)).forEach(System.out::println);
    }

    public static String[] sort(String[] unsorted) {

        for (String item : unsorted) {
            for (int i = 1; i < unsorted.length; i++) {
                if (unsorted[i].compareTo(unsorted[i - 1]) < 0) {
                    String temp = unsorted[i];
                    unsorted[i] = unsorted[i - 1];
                    unsorted[i - 1] = temp;

                   // System.out.println(temp);
                }
            }
        }

        return unsorted;
    }


}
