package arithmetic.binarysearch;

import java.util.Objects;

public class BinarySearchRecursive {

    public static void main(String[] args) {
        int[] table = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(search(table, 9));
    }

    public static int search(int[] table, int searchedItem) {
        // exceptional situations
        Objects.requireNonNull(table, "Table should not be null.");
        int startIndex = 0;
        int endIndex = table.length - 1;

        if (table.length == 0) {
            return -1;
        }
        return recursiveSearch(table, searchedItem, startIndex, endIndex);
    }

    public static int recursiveSearch(int[] table, int searchedItem, int startIndex, int endIndex) {
        int midIndex = (startIndex + endIndex) / 2;  // new midIndex for every iteration

        if (startIndex > endIndex ) {
            return -1;
        }

        if (table[midIndex] == searchedItem) {
            return midIndex;
        } else if (table[midIndex] > searchedItem) {
            return recursiveSearch(table, searchedItem, startIndex, midIndex - 1);
        } else {
            return recursiveSearch(table, searchedItem, midIndex + 1, endIndex);
        }
    }
}
