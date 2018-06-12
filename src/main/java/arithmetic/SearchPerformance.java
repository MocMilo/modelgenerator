package arithmetic;

import arithmetic.binarysearch.BinarySearchIteration;
import arithmetic.binarysearch.BinarySearchRecursive;
import performancetests.wormupjvm.ManualClassLoader;

import java.text.DecimalFormat;
import java.util.function.Consumer;

import static java.lang.System.out;

public class SearchPerformance {
    private static int TEST_COLLECTION_LIMIT = 100000000;

    public static void main(String[] args) {
        int[] table =  generateData();
        int target = 5;

        warmUpJVM();

        System.out.println("BinarySearch - Recursive");
        System.out.println("BinarySearch - Iteration");

        checkTime(v -> BinarySearchRecursive.search(table, target));
        checkTime(v -> BinarySearchIteration.search(table, target));
    }

    private static int[] generateData() {
        int[] data = new int[TEST_COLLECTION_LIMIT];
        for (int i = 0; i < TEST_COLLECTION_LIMIT; i++) {
            data[i] = i;
        }
        return data;
    }

    private static void checkTime(Consumer<Void> aVoid) {
        long startTime = System.nanoTime();
        aVoid.accept(null);
        final long duration = System.nanoTime() - startTime;
        final double seconds = ((double) duration / 1000000000);
        out.println("\t\t" + new DecimalFormat("#.##########").format(seconds) + " seconds");
    }

    private static void warmUpJVM() {
        out.println("Wait, JVM warm up...");
        ManualClassLoader.load();
    }
}
