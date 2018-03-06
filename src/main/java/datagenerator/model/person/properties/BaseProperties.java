package datagenerator.model.person.properties;

import datagenerator.model.person.enums.Country;
import datagenerator.model.person.enums.Gender;
import datagenerator.model.person.enums.Profession;

import java.time.LocalDate;

public class BaseProperties {


    private Gender gender;
    private LocalDate dateOfBirth;
    private float iqIndex;
    private double fbRank;
    private Profession profession;
    private Country country;

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
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

    public Country getCountry() {
        return country;
    }

    public BaseProperties(Gender gender, LocalDate dateOfBirth, float iqIndex, double fbRank, Profession profession, Country country) {
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.iqIndex = iqIndex;
        this.fbRank = fbRank;
        this.profession = profession;
        this.country = country;
    }
}
