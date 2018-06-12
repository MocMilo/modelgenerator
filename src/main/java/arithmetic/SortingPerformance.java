package arithmetic;

import arithmetic.bubblesorting.BubbleSorting;
import datagenerator.model.person.Person;
import performancetests.wormupjvm.ManualClassLoader;
import training.java8streams.approach1.FileUtil;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.lang.System.out;


public class SortingPerformance {
    private static int TEST_COLLECTION_LIMIT = 200;   // max 300

    public static void main(String[] args) throws IOException {
        Person[] unsorted1 = getData();
        Person[] unsorted2 = getData();
        Person[] unsorted3 = getData();

        warmUpJVM();

        Comparator<Person> comparator = Comparator.comparing(Person::getHight);
        String comparisonField = "hight";

        out.println("Bubble sorting - using reflection");
        out.println("Bubble sorting - using comparator");
        out.println("Arrays.sort()  - using comparator");

        checkTime((v) -> doBubbleSortWithReflection(unsorted1, comparisonField));
        checkTime((v) -> doBubbleSortWithComparator(unsorted2, comparator ));
        checkTime((v) -> doArraysSort(unsorted3, comparator));
    }

    private static void doBubbleSortWithReflection(Person[] array, String comparisonField) {
        BubbleSorting.sortPersonArray(array, comparisonField);
    }

    private static void doBubbleSortWithComparator(Person[] array, Comparator<Person> comparator) {
        BubbleSorting.sortObjectArrayWithComparator(array, comparator);
    }

    private static void doArraysSort(Person[] array, Comparator<Person> comparator) {
        Arrays.sort(array, comparator);
    }

    private static Person[] getData() throws IOException{
        return new FileUtil().getTasksModel()
                .stream()
                .limit(TEST_COLLECTION_LIMIT)
                .collect(Collectors.toList())
                .toArray(new Person[0]);
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
