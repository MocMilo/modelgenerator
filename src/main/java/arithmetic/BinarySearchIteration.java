package arithmetic;

public class BinarySearchIteration {

    public static void main(String[] args) {
        int[] table = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(search(table, 3));
    }

    public static int search(int[] table, int searchedItem) {
        int startIndex = 0;
        int endIndex = table.length - 1;
        int initMiddleIndex = endIndex / 2;

        // exceptional situations
        if (table.length == 0) {
            throw new IllegalArgumentException();
        }
        if (searchedItem < table[0]) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (searchedItem > table[table.length-1]) {
            throw new ArrayIndexOutOfBoundsException();
        }
        // optimistic case
        if (searchedItem == initMiddleIndex) {
            return initMiddleIndex;
        }

        // SEARCH
        // midIndex is supposed to be equal with searched item in a loop

        // the same algorithm works for "foreach" and "for" loop
        // for (int i : table){...}
        // for (int i = 0; i < table.length; i++)

        int whileLoopResult;
        while (true) {                                   // escape with return statement
            int midIndex = (startIndex + endIndex) / 2;  // new midIndex for every iteration
            if (table[midIndex] < searchedItem) {
                startIndex = midIndex + 1;               // conditional index change
            } else if (table[midIndex] > searchedItem) {
                endIndex = midIndex - 1;
            } else if (table[midIndex] == searchedItem) {
                whileLoopResult = searchedItem;
                break;
            }
        }
        return whileLoopResult;
    }
}

