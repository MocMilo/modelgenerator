package training.java8streams.drill0;

import datagenerator.model.person.Person;
import datagenerator.builders.PersonContainerBuilder;

import java.util.List;

public class Program {


    public static void main(String[] args) {

        List<Person> personList = new PersonContainerBuilder()
                .getContainer()
                .getPeopleList();

        // TODO stream operations

        // print list
        printPeopleList(personList);
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
    }
}
