package training.sorting;

import datagenerator.model.person.Person;
import training.java8streams.approach1.FileUtil;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class SortingTraining {


    public static void main(String[] args) throws IOException {

        List<Person> personList = new FileUtil().getTasksModel();
        System.out.println("person size: " + personList.size());  // returns 300 elements

        Set<Person> personHashSet = new HashSet<>(personList);
        System.out.println("PersonHashSet size: " + personHashSet.size()); // returns 300 elements

        // Person has no Comparator or Comparable implemented in class
        // Trying to implement comparator to TreeSet without touching Person class:
        Set<Person> personTreeSet = new TreeSet<>(Comparator.comparing(Person::getHight));
        personTreeSet.addAll(personList);

        System.out.println("Person Set size: " + personTreeSet.size()); // why only 49 elements ??

        // checking code ln:23
        int u = personList.stream()
                .map(Person::getHight)
                .distinct()
                .collect(Collectors.toList()).size();

        System.out.println("distinct person height size: " + u);   //  49 elements, distinct by Person hight


        // just printing results...
        System.out.println("\n \n origin Person list");
        personList.forEach(x -> {
            System.out.println(x.toString());
        });

        System.out.println("\n \n Person List as HashSet");
        personHashSet.forEach(x -> {
            System.out.println(x.toString());
        });

        System.out.println("\n \n Person List in ThreeSet");
        personTreeSet.forEach(x -> {
            System.out.println(x.toString());
        });

        //
        // personList.sort(Comparator.comparing(Person::getHight).reversed());

    }
}
