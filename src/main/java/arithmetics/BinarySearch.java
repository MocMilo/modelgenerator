package arithmetics;

public class BinarySearch {

    public static void main(String[] args) {
        int[] table = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(search(table, 3));
    }

    public static int search(int[] table, int searchedItem) {
        int startIndex = 0;
        int endIndex = table.length-1;
        int initMiddleIndex = endIndex / 2;

        if (table.length == 0) {
            throw new IllegalArgumentException();
        }
        if (searchedItem > table.length) {
            throw new IllegalArgumentException();
        }
        if (searchedItem == initMiddleIndex) {
            return initMiddleIndex;
        }

        int escape = 0;
        while (initMiddleIndex != searchedItem) {
            int dynamicMiddleIndex = (endIndex - startIndex) / 2;
            if (searchedItem < dynamicMiddleIndex) {
                endIndex = dynamicMiddleIndex;
                if (searchedItem == dynamicMiddleIndex)
                    return searchedItem;
            }
            if (searchedItem > dynamicMiddleIndex) {
                startIndex = dynamicMiddleIndex;
                endIndex = table.length;
                if (searchedItem == startIndex)
                    return searchedItem;
            }
            escape++;
            if (escape > 100) {
                System.out.println("infinite loop escape");
                return -1;
            }
        }
        System.out.println("algorithm failure");
        return -1;
    }
}
