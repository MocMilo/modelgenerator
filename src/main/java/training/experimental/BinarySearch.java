package training.experimental;

public class BinarySearch {

    public static void main(String[] args) {
        int[] table = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(search(table, 9));
    }

    private static int search(int[] table, int searchedNumber) {
        int startIndex = 0;
        int endIndex = table.length - 1;

        int count = 0;
        while (startIndex <= endIndex) {
            count++;
            int middleIndex = (startIndex + endIndex) / 2;
            if (table[middleIndex] == searchedNumber) {
                System.out.println("count: " + count);
                return middleIndex;
            } else if (table[middleIndex] > searchedNumber) {
                endIndex = middleIndex - 1;
            } else if (table[middleIndex] < searchedNumber) {
                startIndex = middleIndex + 1;
            }
        }
        return -1;
    }
}
