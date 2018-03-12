package datagenerator.builders;

import datagenerator.model.person.Person;
import datagenerator.model.person.enums.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class PersonBuilder {
    private int id;
    private String name;
    private String surname;
    private Gender gender;
    private LocalDate dateOfBirth;
    private BigDecimal sallary;
    private int hight;
    private float iqIndex;
    private double fbRank;
    private Profession profession;
    private BodyType bodyType;
    private Country country;
    private HairColour hairColour;
    private EyesColour eyesColour;
    private Set<Person> friends;

    public PersonBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public PersonBuilder setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public PersonBuilder setSallary(BigDecimal sallary) {
        this.sallary = sallary;
        return this;
    }

    public PersonBuilder setHight(int hight) {
        this.hight = hight;
        return this;
    }

    public PersonBuilder setIqIndex(float iqIndex) {
        this.iqIndex = iqIndex;
        return this;
    }

    public PersonBuilder setFbRank(double fbRank) {
        this.fbRank = fbRank;
        return this;
    }

    public PersonBuilder setProfession(Profession profession) {
        this.profession = profession;
        return this;
    }

    public PersonBuilder setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
        return this;
    }

    public PersonBuilder setCountry(Country country) {
        this.country = country;
        return this;
    }

    public PersonBuilder setHairColour(HairColour hairColour) {
        this.hairColour = hairColour;
        return this;
    }

    public PersonBuilder setEyesColour(EyesColour eyesColour) {
        this.eyesColour = eyesColour;
        return this;
    }

    public PersonBuilder setFriends(Set<Person> friends) {
        this.friends = friends;
        return this;
    }

    public Person createPerson() {
        return new Person(id, name, surname, gender, dateOfBirth, sallary, hight, iqIndex, fbRank, profession, bodyType, country, hairColour, eyesColour, friends);
    }
}