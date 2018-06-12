package training.java8streams.approach3;

import datagenerator.model.person.Person;
import training.java8streams.approach1.FileUtil;
import training.java8streams.approach1.NoDataException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;


public class App {
    public static void main(String[] args) throws IOException {
        // new FileUtil().saveModelFile(); // uncomment to save new generated data to model file
        // new FileUtil().savePersonNamesContainerToFile(); //
        List<Person> personList = new FileUtil().getTasksModel();
        System.out.println("personListSize: " + personList.size());


        //  Set<Person> sortedList = new TreeSet<>(personList);
        // Person has to have comparable implemented to use in TreeSet otherwise exception
        //   sortedList.forEach(System.out::println);

        System.out.println("-----------------");
        personList.forEach(System.out::println);
        System.out.println("-----------------");
       // Collections.sort(personList, Person.BY_BODY_TYPE);

        personList.forEach(System.out::println);

        Set<Person> sortedSetByAge = new TreeSet<>(Comparator.comparing(Person::getHight));
        sortedSetByAge.addAll(personList);
        System.out.println("-----------------");
        sortedSetByAge.forEach(System.out::println);

        List<Integer> integers = new ArrayList<>(Arrays.asList(1,2,4));
        List<Integer> integersShallowCopy = integers;

        System.out.println(integers);

        integersShallowCopy.remove(1);
        System.out.println("original" + integers);
        System.out.println("shalowCopy" + integersShallowCopy);

        List<Integer> deepCopy = new ArrayList<>(Collections.unmodifiableList(integers));
        deepCopy.add(5);

        System.out.println("original" + integers);
        System.out.println("shallowCopy" + integersShallowCopy);
        System.out.println("shallowCopy" + deepCopy);

        new ArrayList();
        new LinkedList<>();


        // Task 1
        // Task 2
        // Task 3
        // Task 4
        // Task 5
        // Task 6

        List<Person> task6 = new FileUtil().getTasksModel();


        System.out.println(task6.size());

        OptionalInt maxHeight = task6.stream().mapToInt(Person::getHight).max();
        Optional<Integer> maxHeight2 = task6.stream().map(Person::getHight).findFirst();

        System.out.println(maxHeight.orElseThrow(NoClassDefFoundError::new));

        Person height = task6.stream()
                .filter(x -> x.getHight() > 170)
                .findFirst()
                .orElseThrow(NoDataException::new);


        OptionalDouble height2 = task6.stream()
                .mapToDouble(Person::getHight)
                .average();

        System.out.println(height2);

        Optional<BigDecimal> sallarySum = task6.stream()
                .map(Person::getSalary)
                .reduce(BigDecimal::add);

        System.out.println(sallarySum);


        // Task 7
        // Task 8

    }
}
