package datagenerator.model.person.properties;

import datagenerator.model.person.Person;
import datagenerator.model.person.enums.BodyType;
import datagenerator.model.person.enums.EyesColour;
import datagenerator.model.person.enums.HairColour;

import java.math.BigDecimal;
import java.util.HashSet;

public class CountrySpecificProperties {

    private EyesColour eyesColour;
    private HairColour hairColour;
    private BodyType bodyType;
    private BigDecimal sallary;
    private int height;
    private String name;
    private String surname;
    private HashSet<Person> friends;

    public EyesColour getEyesColour() {
        return eyesColour;
    }

    public HairColour getHairColour() {
        return hairColour;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public BigDecimal getSallary() {
        return sallary;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public HashSet<Person> getFriends() {
        return friends;
    }

    public CountrySpecificProperties(EyesColour eyesColour, HairColour hairColour, BodyType bodyType, BigDecimal sallary, int height, String name, String surname, HashSet<Person> friends) {
        this.eyesColour = eyesColour;
        this.hairColour = hairColour;
        this.bodyType = bodyType;
        this.sallary = sallary;
        this.height = height;
        this.name = name;
        this.surname = surname;
        this.friends = friends;
    }
}
