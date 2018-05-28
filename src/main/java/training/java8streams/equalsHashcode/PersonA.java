package training.java8streams.equalsHashcode;

import datagenerator.model.person.Person;

import java.util.Objects;

public class PersonA extends BasePerson {

   private int Id;
   private String name;
   private int age;

    public PersonA(int id, String name, int age) {
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
        PersonA that = (PersonA) o;
        return Id == that.Id &&
                age == that.age &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, age);
    }


}

/*
* 	public int compareTo(Fruit compareFruit) {

		int compareQuantity = ((Fruit) compareFruit).getQuantity();

		//ascending order
		return this.quantity - compareQuantity;
* */