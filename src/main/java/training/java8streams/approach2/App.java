package training.java8streams.approach2;

import datagenerator.model.person.Person;
import datagenerator.model.person.enums.Gender;
import training.java8streams.approach1.FileUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class App {

    public static void main(String[] args) throws IOException {

        List<Person> personList = new FileUtil().getTasksModel();
        System.out.println("personListSize: " + personList.size());

        // Task 1 15 min
        Predicate<Person> startsWithA = x -> x.getName().startsWith("a");
        Predicate<Person> salaryAbove12000 = x -> x.getSalary().compareTo(new BigDecimal("12.000")) > 0;

        Consumer<Person> printPersonHeight = x -> System.out.println("person height: " + x.getHight());
        Consumer<Person> printCapitalLeters = x -> System.out.println("person Name: "
                + x.getName().toUpperCase());

        personList.forEach(printCapitalLeters);

        Supplier<Optional<Person>> personSupplier = () -> personList.stream().findAny();

        // Task 2 41 min
        long[] arr = {1, 2, 3, 4};
        List<Long> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Function<Long, Double> function = x -> x.doubleValue();
        List<Double> doubleList = map(list, function);
        doubleList.forEach(x -> System.out.println("double: " + x.toString()));

        Function<Person, String> threeFirstLettersCut = x -> (x.getName().toCharArray().length > 3) ? x.getName().substring(0, 3) : "two letter name";
        List<String> shortNames = map(personList, threeFirstLettersCut);

        System.out.println(shortNames.size());
        shortNames.forEach(System.out::println);

        //Task 3  22 min.

        // java 7
        Comparator<String> stringComparatorJava7 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        Comparator<Integer> intComparatorJava7 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        Comparator<Person> personNameComparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };


        // java 8
        Comparator<String> stringComparator = (o1, o2) -> o1.compareTo(o2);
        Comparator<String> stringComparator1 = Comparator.naturalOrder();
        Comparator<Integer> integerComparator = Comparator.naturalOrder();
        Comparator<Person> personComparator = Comparator.comparing(Person::getName);
        Comparator<Person> personComparator1 = Comparator.comparing(Person::getHight);

        Comparator<Person> personComparator2 = Comparator.comparing(Person::getSalary);
        Comparator<Person> personComparator3 = Comparator.comparing(Person::getName)
                .thenComparing(Person::getHight)
                .thenComparing(Person::getSalary);

        // Task 4 10 min create stream of ints

        IntStream intStream = IntStream.range(0, 1000);
        IntStream intStream2 = IntStream.range(0, new Random().nextInt(1000));

        // Task 5 12 min

        Supplier<Person> personSupplier1 = () -> personList.get(0);

        Stream<Person> personStream = personList.stream();
        //Stream<Person> personStream1 = personSupplier1.get(). // don't know

        //Foo[] array = list.toArray(new Foo[list.size()]);

        Person[] people = personList.toArray(new Person[personList.size()]);
        Stream<Person> personStream2 = Stream.of(people);

        // Task 6 40 min
        List<Person> limitedTo5Items = personList.stream()
                .limit(5)
                .collect(Collectors.toList());

        Optional<Person> firstItem = personList.stream()
                .findFirst();

        long numberOfItems = personList.stream().count();

        Optional<Person> personHigherThan175 = personList.stream()
                .filter(x -> x.getHight() > 175)
                .findFirst();

        int maxHeight = personList.stream()
                .mapToInt(Person::getHight)
                .sum();

        OptionalInt maxHeight2 = personList.stream()
                .mapToInt(Person::getHight)
                .reduce((o1, o2) -> o1 + o2);

        System.out.println("maxheight OptionalInt:" + maxHeight2.getAsInt());
        ;
        System.out.println("maxheight Int: " + maxHeight);


        Optional<Integer> maxHeight3 = personList.stream()
                .map(Person::getHight)
                .reduce((o1, o2) -> o1 + o2);

        Integer maxHeight4 = personList.stream()
                .mapToInt(Person::getHight)
                .reduce((o1, o2) -> o1 + o2)
                .orElseThrow(NoDataCustomException::new);

        int minHeight = personList.stream()
                .mapToInt(Person::getHight)
                .sum();
        OptionalDouble avrHeight = personList.stream()
                .mapToInt(Person::getHight)
                .average();

        double varHeight2 = personList.stream()
                .mapToInt(Person::getHight)
                .average()
                .orElseThrow(NoDataCustomException::new);

        Optional<Person> smallestPerson = personList.stream()
                .min(Comparator.comparing(Person::getHight));

        //Task 7 45 min
        List<Person> filtered90s = personList.stream()
                .filter(x -> x.getDateOfBirth().isAfter(LocalDate.of(1989, 12, 31)))
                .filter(x -> x.getDateOfBirth().isBefore(LocalDate.of(2000, 1, 30)))
                .collect(Collectors.toList());

        List<Person> sortedBySalary = personList.stream()
                .sorted(Comparator.comparing(Person::getSalary))
                .collect(Collectors.toList());

        List<Person> youngestWomen = personList.stream()
                .filter(x -> x.getGender().equals(Gender.W))
                .sorted(Comparator.comparing(Person::getSalary))
                .limit(3)
                .collect(Collectors.toList());

        List<Person> oldestMen = personList.stream()
                .filter(x -> x.getGender().equals(Gender.M))
                .sorted(Comparator.comparing(Person::getDateOfBirth).reversed())
                .limit(3)
                .collect(Collectors.toList());

        Optional<Person> highestPerson = personList.stream()
                .max(Comparator.comparing(Person::getHight));

        System.out.println("highest person: " + highestPerson.get().getHight());

        double averageHeight = personList.stream()
                .mapToInt(Person::getHight)
                .average()
                .orElseThrow(NoDataCustomException::new);

        double averageHeight2 = personList.stream()
                .collect(Collectors.averagingDouble(Person::getHight));


        BigDecimal summary = personList.stream()
                .map(Person::getSalary)
                .reduce((o1, o2) -> o1.add(o2))
                .orElseThrow(NoDataCustomException::new);

        BigDecimal averageSallary = summary.divide(new BigDecimal(personList.size()))
                .setScale(2, RoundingMode.HALF_EVEN);

        personList.stream()
                .map(Person::getSalary)
                .max(BigDecimal::compareTo);


        System.out.println("average salary: " + averageSallary);

        // Task 8
        Map<Gender, Double> averageGenderHeight = personList.stream()
                .collect(Collectors.groupingBy(
                        Person::getGender, Collectors.averagingDouble(Person::getHight)));

        Map<Gender, Optional<Person>> tallestPersonPerGender = personList.stream()
                .collect(Collectors.groupingBy(
                        Person::getGender, Collectors.maxBy(Comparator.comparing(Person::getHight))));

        Map<Gender, Optional<Person>> maxSalaryPersonPerGender = personList.stream()
                .collect(Collectors.groupingBy(
                        Person::getGender, Collectors.maxBy(Comparator.comparing(Person::getSalary))));

    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> out = new ArrayList<>();
        for (T item : list) {
            R r = function.apply(item);
            out.add(r);
        }
        return out;
    }
}
