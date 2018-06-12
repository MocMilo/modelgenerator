package training.java8streams.equalsHashcode;

import java.util.Objects;

public class PersonB extends BasePerson {
    private int Id;
    private String name;
    private int age;

    public PersonB(int id, String name, int age) {
        Id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonB that = (PersonB) o;
        return Id == that.Id &&
                age == that.age &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, age);
    }
}
