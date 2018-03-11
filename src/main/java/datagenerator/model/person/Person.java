package datagenerator.model.person;

import datagenerator.model.person.enums.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Person {
    private int Id;
    private String name;
    private String surname;
    private Gender gender;
    private LocalDate dateOfBirth;
    private BigDecimal salary;
    private int hight;
    private float iqIndex;
    private double fbRank;
    private Profession profession;
    private BodyType bodyType;
    private Country country;
    private HairColour hairColour;
    private EyesColour eyesColour;

    private Set<Person> friends;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public int getHight() {
        return hight;
    }

    public float getIqIndex() {
        return iqIndex;
    }

    public double getFbRank() {
        return fbRank;
    }

    public Profession getProfession() {
        return profession;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public Country getCountry() {
        return country;
    }

    public Set<Person> getFriends() {
        return friends;
    }

    public Person() {
    }

    public Person(int id, String name, String surname, Gender gender, LocalDate dateOfBirth, BigDecimal sallary, int hight, float iqIndex, double fbRank, Profession profession, BodyType bodyType, Country country, HairColour hairColour, EyesColour eyesColour, Set<Person> friends) {
        Id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.salary = sallary;
        this.hight = hight;
        this.iqIndex = iqIndex;
        this.fbRank = fbRank;
        this.profession = profession;
        this.bodyType = bodyType;
        this.country = country;
        this.hairColour = hairColour;
        this.eyesColour = eyesColour;
        this.friends = friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Id == person.Id &&
                hight == person.hight &&
                Float.compare(person.iqIndex, iqIndex) == 0 &&
                Double.compare(person.fbRank, fbRank) == 0 &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                gender == person.gender &&
                Objects.equals(dateOfBirth, person.dateOfBirth) &&
                Objects.equals(salary, person.salary) &&
                profession == person.profession &&
                bodyType == person.bodyType &&
                country == person.country &&
                hairColour == person.hairColour &&
                eyesColour == person.eyesColour &&
                Objects.equals(friends, person.friends);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Id, name, surname, gender, dateOfBirth, salary, hight, iqIndex, fbRank, profession, bodyType, country, hairColour, eyesColour, friends);
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", salary=" + salary +
                ", hight=" + hight +
                ", iqIndex=" + iqIndex +
                ", fbRank=" + fbRank +
                ", profession=" + profession +
                ", bodyType=" + bodyType +
                ", country=" + country +
                ", hairColour=" + hairColour +
                ", eyesColour=" + eyesColour +
                ", friends=" + friends +
                '}';
    }
}
