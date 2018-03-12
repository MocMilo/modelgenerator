package datagenerator.model.person;

import java.util.List;
import java.util.Set;

public class PersonContainer {

    private String example;
    private List<Person> peopleList;
    private Set<Person> personSet;

    public String getExample() {
        return example;
    }

    public List<Person> getPeopleList() {
        return peopleList;
    }

    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public void setPeopleList(List<Person> peopleList) {
        this.peopleList = peopleList;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }

    public PersonContainer() {
    }

    public PersonContainer(String example, List<Person> peopleList, Set<Person> personSet) {
        this.example = example;
        this.peopleList = peopleList;
        this.personSet = personSet;
    }
}
