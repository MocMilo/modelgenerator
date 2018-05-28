package training.java8streams.approach3;

import datagenerator.model.person.Person;
import datagenerator.model.person.enums.Gender;
import training.java8streams.approach1.FileUtil;
import training.java8streams.approach1.NoDataException;

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

        // Task 1

        // Task 2

        // Task 3

        // Task 4

        // Task 5

        // Task 6

        // Task 7

        // Task 8

    }
}
