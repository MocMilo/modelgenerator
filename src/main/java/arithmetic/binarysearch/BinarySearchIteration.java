package arithmetic.binarysearch;

import java.util.HashMap;
import java.util.Objects;

public class BinarySearchIteration {

    public static void main(String[] args) {
        int[] table = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(search(table, 4));
    }

    /**
     * @param table
     * @param searchedValue
     * @return index of value or -1 (not found)
     */
    public static int search(int[] table, int searchedValue) {
        // exceptional situations
        Objects.requireNonNull(table, "Table should not be null.");

        if (table.length == 0) {
            return -1;
        }

        int startIndex = 0;
        int endIndex = table.length - 1;

        // SEARCH...
        // midIndex is supposed to be equal with searched item in a loop

        // the same algorithm works for "foreach" and "for" loop
        // for (int i : table){...}
        // for (int i = 0; i < table.length; i++){...}

        while (startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;  // new midIndex for every iteration
            if (table[midIndex] == searchedValue) {
                return midIndex;
            } else if (table[midIndex] < searchedValue) {
                startIndex = midIndex + 1;               // conditional index change
            } else if (table[midIndex] > searchedValue) {
                endIndex = midIndex - 1;
            }

            new HashMap();
        }
        System.out.println("value not found");
        return -1;
    }
}

