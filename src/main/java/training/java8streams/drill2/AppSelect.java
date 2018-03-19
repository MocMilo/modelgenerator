package training.java8streams.drill2;

import datagenerator.model.person.Person;
import datagenerator.builders.PersonContainerBuilder;
import datagenerator.model.person.enums.BodyType;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static datagenerator.model.person.enums.Gender.W;

public class AppSelect {

    public static void main(String[] args) {
        final List<Person> personList = new PersonContainerBuilder()
                .getContainer()
                .getPeopleList();

        List<Person> selected = personList.stream()
                .filter(x -> x.getGender().equals(W))
                .filter(x -> x.getDateOfBirth().isAfter(LocalDate.of(1993,1,1))
                && x.getDateOfBirth().isBefore(LocalDate.of(1999,1,1)))
                .filter(x -> x.getFbRank() > 8.0)
                .filter(x -> x.getIqIndex() > 100)
                .filter(x -> x.getBodyType().equals(BodyType.SLIM))
                .sorted(Comparator.comparing(Person::getDateOfBirth).reversed())
                .collect(Collectors.toList());

        System.out.println("selected: ");
        selected.forEach( x -> System.out.println(x.toString()));



    }

}
