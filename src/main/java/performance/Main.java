package performance;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import java.util.function.Consumer;

public class Main {
                                            // 10000000
    private static final int COLLECTION_SIZE = 5000000;

    public static void main(String[] args) {

        String arrayListElement = "arrayListElement";
        String linkedHashSetElement = "linkedHashSetElement";

        ArrayList<String> arrayList = new ArrayList<>();
        ArrayDeque<String> linkedHashSet = new ArrayDeque<>();

        // populate collections
        System.out.println("add n elements: ");
        checkTime((v) -> populateCollection(arrayList, COLLECTION_SIZE));
        checkTime((v) -> populateCollection(linkedHashSet, COLLECTION_SIZE));

        // add one element
        System.out.println("add one element: ");
        checkTime((v) -> arrayList.add(arrayListElement));
        checkTime((v) -> linkedHashSet.add(linkedHashSetElement));

        // contains element
        System.out.println("contains element: ");
        checkTime((v) -> arrayList.contains(arrayListElement));
        checkTime((v) -> linkedHashSet.contains(linkedHashSetElement));

        // get element
        System.out.println("get elements: ");
        checkTime((v) -> arrayList.get(COLLECTION_SIZE));
        checkTime((v) -> {

            linkedHashSet.stream()
                    .filter(element -> element.equals(linkedHashSetElement))
                    .findAny()
                    .orElse(null);

        });
        // remove element
        System.out.println(" remove element");
        checkTime((v) -> arrayList.remove(arrayListElement));
        checkTime((v) -> linkedHashSet.remove(linkedHashSetElement));
    }

    private static void checkTime(Consumer<Void> aVoid) {
        long startTime = System.nanoTime();
        aVoid.accept(null);
        final long duration = System.nanoTime() - startTime;
        final double seconds = ((double)duration / 1000000000);
        System.out.println("\t\t" + new DecimalFormat("#.##########").format(seconds) + " seconds");
    }

    /**
     *
     * @param collection
     * @param size
     * @return
     */
    private static void populateCollection(Collection collection, int size) {
        for (int i = 1; i <= size; i++) {
            String randomString = UUID.randomUUID().toString();
            collection.add(randomString);
        }
    }
}
