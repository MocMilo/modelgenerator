package arithmetic.binarysearch;

import java.util.Objects;

public class BinarySearchIteration {

    public static void main(String[] args) {
        int[] table = {-2,-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(search(table, 3));
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

        while (startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;  // new midIndex for every iteration
            if (table[midIndex] == searchedValue) {
                return midIndex;
            } else if (table[midIndex] < searchedValue) {
                startIndex = midIndex + 1;               // conditional index change
            } else if (table[midIndex] > searchedValue) {
                endIndex = midIndex - 1;
            }
        }
        System.out.println("value not found");
        return -1;
    }
}

