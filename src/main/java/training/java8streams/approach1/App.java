package training.java8streams.approach1;

import datagenerator.model.person.Person;
import datagenerator.model.person.enums.Gender;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static datagenerator.model.person.enums.Gender.M;
import static datagenerator.model.person.enums.Gender.W;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;


public class App {


    public static void main(String[] args) throws IOException {
        // new FileUtil().saveModelFile(); // uncomment to save new generated data to model file
        // new FileUtil().savePersonNamesContainerToFile(); //
        List<Person> personList = new FileUtil().getTasksModel();
        System.out.println("personListSize: " + personList.size());

        // Task1
        Predicate<Person> personStartingWithA = x -> x.getName().startsWith("a");
        Predicate<Person> salaryMoreThan12000 = x -> (x.getSalary().compareTo(new BigDecimal("12000.00"))) > 0;

        Consumer<Person> printHeight = x -> System.out.println(x.getHight());
        Consumer<Person> printNamesAndNamesLengths = x ->
                System.out.println("name: " + x.getName().toUpperCase()
                        + " length: " + x.getName().length());

        personList.forEach(printNamesAndNamesLengths);

        Supplier<Person> getPerson = () -> personList.stream()
                .findAny()
                .orElseThrow(NoDataException::new);

        // Task 2
        // List<Long> -> List<Double>
        List<Long> longList = Arrays.asList(2L, 3L, 4L, 5L);

        List<Double> doubleList = map(longList, x -> x.doubleValue());

        System.out.println("double values:");
        longList.forEach(x -> System.out.println(x.toString()));
        doubleList.forEach(x -> System.out.println(x.toString()));

        // Task 3 Java 7
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        Comparator<String> stringComparator2 = (x, y) -> x.compareTo(y);
        Comparator<String> stringComparator3 = Comparator.naturalOrder();
        Comparator<Integer> stringComparator4 = (x, y) -> x.compareTo(y);
        Comparator<Integer> stringComparator5 = Comparator.naturalOrder();

        Comparator<Person> personComparator1 = Comparator.comparing(Person::getName);
        Comparator<Person> personComparator2 = Comparator.comparing(Person::getHight);
        Comparator<Person> personComparator3 = Comparator.comparing(Person::getSalary);

        Comparator<Person> multiPersonComparator = Comparator.comparing(Person::getName)
                .thenComparing(Person::getHight).thenComparing(Person::getSalary);

        // Task 4
        IntStream integerStream = IntStream.rangeClosed(0, 1000);
        IntStream randomIntStreamUpTo1000 = new Random().ints(1000);

        // Task 5
        Person[] personArray = personList.toArray(new Person[personList.size()]);

        Stream<Person> personStream1 = personList.stream();
        Stream<Person> personStream2 = Stream.generate(getPerson);
        Stream<Person> personStream3 = Stream.of(personArray);
        Stream<Person> personStream4 = Arrays.stream(personArray);

        // Task 6
        List<Person> limitedTo5 = personList.stream()
                .limit(5)
                .collect(Collectors.toList());

        Optional<Person> firstPerson = personList.stream()
                .findFirst();

        long numberOfItems = personList.stream().count();
        int numberOfItems2 = personList.size();

        List<Person> personListTallerThan190 = personList.stream()
                .filter(x -> x.getHight() > 160)
                .collect(Collectors.toList());
        System.out.println(">160 people number: " + personListTallerThan190.size());

        OptionalInt maxHeight1 = personList.stream()
                .mapToInt(Person::getHight)
                .max();

        Optional<Integer> maxHeight2 = personList.stream()
                .map(Person::getHight)
                .max(Comparator.naturalOrder());

        Integer maxHeight3 = personList.stream()
                .map(Person::getHight)
                .max(Comparator.naturalOrder())
                .orElseThrow(NoDataException::new);

        int maxHeight4 = personList.stream()
                .map(Person::getHight)
                .min(Comparator.naturalOrder())
                .orElseThrow(NoDataException::new);

        OptionalDouble averageHeight = personList.stream()
                .mapToDouble(Person::getHight)
                .average();

        double doubleHeight = personList.stream()
                .mapToDouble(Person::getHight)
                .average().orElseThrow(NoDataException::new);

        int intHeight = (int) personList.stream()
                .mapToDouble(Person::getHight)
                .average().orElseThrow(NoDataException::new);

        Person smallestPerson = personList.stream()
                .min(Comparator.comparing(Person::getHight))
                .orElseThrow(NoDataException::new);

        System.out.println("smallest person: " + smallestPerson.toString());

        // Task 7
        List<String> personNamesBornIn90s = personList.stream()
                .filter(x -> x.getDateOfBirth().isAfter(LocalDate.of(1989, 12, 31)))
                .filter(x -> x.getDateOfBirth().isBefore(LocalDate.of(2000, 01, 01)))
                .map(Person::getName)
                .collect(Collectors.toList());

        personNamesBornIn90s.forEach(System.out::println);

        List<Person> sortedPersonBySalary = personList.stream()
                .sorted(Comparator.comparing(Person::getSalary))
                .collect(Collectors.toList());

        List<Person> youngestWomen = personList.stream()
                .filter(x -> x.getGender().equals(W))
                .sorted(Comparator.comparing(Person::getDateOfBirth).reversed())
                .limit(3)
                .collect(Collectors.toList());

        youngestWomen.forEach(x -> System.out.println(x.toString()));

        List<Person> oldestMen = personList.stream()
                .filter(x -> x.getGender().equals(M))
                .sorted(Comparator.comparing(Person::getDateOfBirth))
                .limit(3)
                .collect(Collectors.toList());

        oldestMen.forEach(x -> System.out.println(x.toString()));

        // PersonList average salary
        final List<BigDecimal> sum = new ArrayList<>();
        personList.forEach(x -> sum.add(x.getSalary()));
        BigDecimal divisor = new BigDecimal(sum.size());

        BigDecimal averageSalary = (sum.stream().reduce((x, y) -> x.add(y)))
                .get()
                .divide(divisor);

        System.out.println("average salary" + averageSalary);

        /*- from List<Person> get Map<Gender, Height> averageGenderHeight
	    (groupBy Person gender height and count averege height per gender) */


        // Task 8
        // average height per Gender as Double (verbose method)
        Map<Gender, Integer> genderHeightMap = new HashMap<>();
        Map<Gender, List<Person>> genderPersonMap = personList.stream()
                .collect(groupingBy(Person::getGender));

        genderPersonMap.forEach((k, v) -> {
            int heightSum = v.stream().mapToInt(Person::getHight)
                    .reduce((o1, o2) -> o1 + o2).orElseThrow(NoDataException::new);
            genderHeightMap.put(k, heightSum / v.size());
        });

        System.out.println("");
        genderHeightMap.forEach((k, v) -> System.out.println("" + k + v));


        // simple version:

        // average salary per Gender as Double
        Map<Gender, Double> averageSalaryPerGender = personList.stream()
                .collect(groupingBy(Person::getGender, Collectors.averagingDouble(Person::getHight)));

        // max salary Person per Gender
        Map<Gender, Optional<Person>> maxSalaryPerson2 = personList.stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.maxBy(Comparator.comparing(Person::getSalary))));

        // when static import of Collectors
        Map<Gender, Optional<Person>> maxSalaryPerson = personList.stream()
                .collect(groupingBy(Person::getGender, maxBy(Comparator.comparing(Person::getSalary))));

        System.out.println("average salary");
        averageSalaryPerGender.forEach((k, v) -> System.out.println("" + k + v));
        System.out.println("max salary person");
        maxSalaryPerson.forEach((k, v) -> System.out.println("" + k + v));
    }

    private static <T, R> List<R> map(List<T> in, Function<T, R> condition) {
        List<R> out = new ArrayList<>();
        for (T item : in) {
            out.add(condition.apply(item));
        }
        return out;
    }


}
