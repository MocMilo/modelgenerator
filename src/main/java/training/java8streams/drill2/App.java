package training.java8streams.drill2;

import datagenerator.model.person.enums.Gender;
import datagenerator.model.person.Person;
import datagenerator.builders.PersonContainerBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static datagenerator.model.person.enums.Gender.W;
import static java.util.stream.Collectors.groupingBy;

public class App {

    public static void main(String[] args) {

        final List<Person> personList = new PersonContainerBuilder()
                .getContainer()
                .getPeopleList();

        final Person[] personArray = personList.toArray(new Person[personList.size()]);
        // Person[] personArray = new Person[personList.size()];
        // personList.toArray(personObjects);

        // Task1
        Predicate<Person> condition1 = x -> x.getName().startsWith("a");

        Predicate<Person> condition2 = x -> (new BigDecimal("12000.00")
                .setScale(2, RoundingMode.HALF_EVEN)
                .compareTo(x.getSalary()) > 0);

        Consumer<Person> personConsumer = x -> System.out.println(x.getName());

        Supplier<Person> personSupplier = () -> personList.get(0);

        // Task 2 TODO

        Function<Person, Integer> personIntegerFunction = x -> x.getHight();

        // Task 3 implement Comparator for Person

        //Java 7
        Comparator<Person> pHightComparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getHight(), o2.getHight());
            }
        };

        Comparator<Person> pNameComparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        //Java 8
        Comparator<Person> pComparator1 = (o1, o2) -> Integer.compare(o1.getHight(), o2.getHight());

        Comparator<Person> pComparator3 = Comparator.comparing(Person::getSalary);

        Comparator<Person> pComparator4 = Comparator.comparing(Person::getHight);

        Comparator<Person> pComparator5 = Comparator.comparing(Person::getName).reversed();

        Comparator<Person> pComparator6 = Comparator.comparing(Person::getHight)
                .thenComparing(Person::getName)
                .thenComparing(Person::getSalary)
                .thenComparing(Person::getDateOfBirth);

        // Task 4 create IntStream TODO:check

        IntStream integerStream = IntStream.range(0, 1001);
        IntStream ints = new Random().ints(200);

        System.out.println("max integer" + integerStream.max().orElseThrow(NullPointerException::new));
        System.out.println("max integer" + ints.max().orElseThrow(NullPointerException::new));

        // Task 5 create Stream<Person>

        Stream<Person> personStream1 = Stream.generate(personSupplier);
        Stream<Person> personStream3 = Arrays.stream(personArray);
        Stream<Person> personStream4 = Stream.of(personArray);
        Stream<Person> personStream2 = personList.stream();

        // Task 6 basic stream reduce operations TODO:check

        List<Person> limitTo5 = personList.stream()
                .limit(5)
                .collect(Collectors.toList());

        Person firstItem = personList.stream()
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        long numberOfItems = personList.stream()
                .count();

        Optional<Person> moreThan190 = personList.stream()
                .filter(x -> x.getHight() > 190)
                .findAny();

        Optional<Integer> maxHeight = personList.stream()
                .map(Person::getHight)
                .max(Comparator.naturalOrder());

        OptionalInt maxHeight3 = personList.stream()
                .mapToInt(Person::getHight)
                .max();

        Integer maxHeight2 = personList.stream()
                .map(Person::getHight)
                .max(Comparator.naturalOrder())
                .orElseThrow(NullPointerException::new);

        Integer minHeight = personList.stream()
                .map(Person::getHight)
                .min(Comparator.naturalOrder())
                .orElseThrow(NullPointerException::new);

        Double averageHeight = personList.stream()
                .mapToInt(Person::getHight)
                .average()
                .orElseThrow(IllegalArgumentException::new);

        OptionalDouble averageHeight2 = personList.stream()
                .mapToInt(Person::getHight)
                .average();

        Double d = averageHeight2.orElseThrow(NullPointerException::new);
        int averageHeightInt = d.intValue();

        Person smallestPerson = personList.stream()
                .min(Comparator.comparing(Person::getHight))
                .orElseThrow(NullPointerException::new);

        System.out.println("smallest person: " + smallestPerson.getName() + smallestPerson.getHight());
        System.out.println("average height: " + averageHeight);
        System.out.println("number of items: " + numberOfItems);

        limitTo5.forEach(System.out::println);
        limitTo5.forEach(x -> System.out.println(x.getName() + x.getDateOfBirth()));

        // Task 7 more advanced

        List<Person> youngestW = personList.stream()
                .filter(x -> x.getGender() == W)
                .sorted(Comparator.comparing(Person::getDateOfBirth).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("selected w:");
        youngestW.forEach(x -> System.out.println(x.toString()));
        /*
         * 1. what I need? Map<Gender, Integer>   (Integer is an average height of gender)
         * 2. what I have? Map<Gender, Person>
         * 3. I use forEach on Map<Gender,Person> and create desired map
         * */

        Map<Gender, Integer> averageHeightPerGender = new HashMap<>();
        Map<Gender, List<Person>> genderPersonList = personList.stream()
                .collect(groupingBy(Person::getGender));

        genderPersonList.forEach((k, v) -> {
            Integer sum = v.stream()
                    .map(Person::getHight)
                    .reduce((o1, o2) -> o1 + o2)
                    .orElseThrow(IllegalArgumentException::new);
            Integer count = v.size();
            averageHeightPerGender.put(k, sum / count);
        });

        averageHeightPerGender.forEach((k, v)
                -> System.out.println(k.toString()
                + " avr: "
                + v.toString()));
    }
}
