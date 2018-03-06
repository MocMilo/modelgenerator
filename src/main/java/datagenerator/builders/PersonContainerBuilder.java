package datagenerator.builders;

import datagenerator.model.person.Person;
import datagenerator.model.person.PersonContainer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PersonContainerBuilder {
    private PersonGenerator generator = new PersonGenerator();
    private PersonContainer container;

    public PersonContainer getContainer() {
        List<Person> personList = new ArrayList();

        for (int i = 0; i < 100; i++) {
            Person random = generator.generate(i);
            personList.add(random);
        }
        container = new PersonContainer("personContainer",
                personList, new HashSet(personList));
        container.setPeopleList(personList);
        return container;
    }
}
