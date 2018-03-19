package training.java8streams.drill1;

import datagenerator.model.person.enums.Gender;
import datagenerator.model.person.Person;
import datagenerator.builders.PersonContainerBuilder;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Program {


    public static void main(String[] args) {

        List<Person> personList = new PersonContainerBuilder()
                .getContainer()
                .getPeopleList();

        // TODO stream operations

        List<Person> personList1 = personList.stream()
                .sorted(Comparator.comparing(Person::getHight))
                .collect(Collectors.toList());

        Map<Gender, List<Person>> personHightMap = personList.stream()
                .collect(groupingBy(Person::getGender));

        // print list
        printPeopleList(personList);
        printPeopleList(personList1);
        pringPeopleMap(personHightMap);
    }

    private static void pringPeopleMap(Map<Gender, List<Person>> map) {
        map.forEach((k, v) -> {
            System.out.println(k.toString());
            v.forEach(x -> printPeopleList(v));
        });
    }

    private static void printPeopleList(List<Person> personList) {
        personList.forEach(x -> {
            System.out.println(
                    "Id: " + x.getId()
                            + " name: " + x.getName()
                            + " gender: " + x.getGender()
                            + " height: " + x.getHight()
                            + " birth date: " + x.getDateOfBirth()
                            + " salary: " + x.getSalary());
        });
        System.out.println("------------");
    }
}
