package arithmetic;

import datagenerator.model.person.Person;
import training.java8streams.approach1.FileUtil;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class BubbleSorting {

    public static void main(String[] args) throws IOException {
        String[] unsorted = {"d", "a", "e", "b", "c", "ze", "zf", "g", "h", "i", "johny", "bravo"};
        String[] sorted = sortStringArray(unsorted);
        Arrays.stream(sorted).forEach(System.out::println);

        Person[] people = new FileUtil().getTasksModel()
                .stream()
                .limit(20)
                .collect(Collectors.toList())
                .toArray(new Person[0]);

        System.out.println("sorted by comparator");
        Person[] sortedByComparator = sortObjectArrayWithComparator(people, Comparator.comparing(Person::getHight));

        Arrays.stream(sortedByComparator).forEach(x -> System.out.println(x.getName() + " " + x.getHight()));



            Person[] sortedByField = sortPersonArray(people, "salary");
            System.out.println("sorted by field");
            Arrays.stream(sortedByField).forEach(x -> System.out.println(x.getName()
                    + " " + x.getSalary()));

    }

    public static String[] sortStringArray(String[] unsorted) {
        for (int o = 1; o < unsorted.length; o++) {
            for (int i = 1; i < unsorted.length; i++) {
                if (unsorted[i - 1].compareTo(unsorted[i]) > 0) {
                    // swap places
                    String temp = unsorted[i];
                    unsorted[i] = unsorted[i - 1];
                    unsorted[i - 1] = temp;
                }
            }
        }
        return unsorted; // already sorted
    }

    public static Person[] sortObjectArrayWithComparator(Person[] unsorted, Comparator<Person> comparator) {
        for (int o = 1; o < unsorted.length; o++) {
            for (int i = 1; i < unsorted.length; i++) {
                if (comparator.compare(unsorted[i - 1], unsorted[i]) > 0) {
                    // swap places
                    Person temp = unsorted[i];
                    unsorted[i] = unsorted[i - 1];
                    unsorted[i - 1] = temp;
                }
            }
        }
        return unsorted; // already sorted
    }

    public static Person[] sortPersonArray(Person[] unsorted, String fieldName) {

        try {
            for (int o = 1; o < unsorted.length; o++) {
                for (int i = 1; i < unsorted.length; i++) {
                    Field field = unsorted[i - 1].getClass()
                            .getDeclaredField(fieldName);
                    field.setAccessible(true);
                    int firstHascode = field.get(unsorted[i - 1]).hashCode();
                    int secondHascode = field.get(unsorted[i]).hashCode();
                    if (firstHascode > secondHascode) {
                        // swap places
                        Person temp = unsorted[i];
                        unsorted[i] = unsorted[i - 1];
                        unsorted[i - 1] = temp;
                    }
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return unsorted;  // already sorted
    }
}
