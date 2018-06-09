package arithmetic;

public class BinarySearchRecursive {

    public static void main(String[] args) {
        int[] table = {-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(search(table, 5));
    }

    public static int search(int[] table, int searchedItem) {
        int startIndex = 0;
        int endIndex = table.length - 1;
        // exceptional situations
        if (table.length == 0) {
            throw new IllegalArgumentException();
        }
        if (searchedItem < table[0]) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (searchedItem > table[table.length - 1]) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return recursiveSearch(table, searchedItem, startIndex, endIndex);
    }

    public static int recursiveSearch(int[] table, int searchedItem, int startIndex, int endIndex) {
        int midIndex = (startIndex + endIndex) / 2;  // new midIndex for every iteration

        if (endIndex < startIndex) {
            return -1;
        }

        if (table[midIndex] == searchedItem) {
            return searchedItem;
        } else if (table[midIndex] > searchedItem) {
            return recursiveSearch(table, searchedItem, startIndex, midIndex - 1);
        } else {
            return recursiveSearch(table, searchedItem, midIndex + 1, endIndex);
        }
    }
}
