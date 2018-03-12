package datagenerator.builders;

import datagenerator.model.person.Person;
import datagenerator.model.person.enums.*;
import datagenerator.model.person.properties.BaseProperties;
import datagenerator.model.person.properties.CountrySpecificProperties;
import datagenerator.builders.strategies.CountrySpecificPropertiesLogic;
import datagenerator.randoms.RandomDate;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static datagenerator.model.person.enums.Gender.M;
import static datagenerator.model.person.enums.Gender.W;

public class PersonGenerator {

    private final LocalDate minDate = LocalDate.of(1975,1,1);
    private final LocalDate maxDate = LocalDate.of(2017,12,31);

    public Person generate(int i) {

        BaseProperties bp = this.generateBaseProperties();
        CountrySpecificProperties cp = new CountrySpecificPropertiesLogic().get(bp);

        Person person = new PersonBuilder()
                .setId(i)
                .setGender(bp.getGender())
                .setDateOfBirth(bp.getDateOfBirth())
                .setFbRank(bp.getFbRank())
                .setProfession(bp.getProfession())
                .setIqIndex(bp.getIqIndex())
                .setCountry(bp.getCountry())

                .setEyesColour(cp.getEyesColour())
                .setHairColour(cp.getHairColour())
                .setBodyType(cp.getBodyType())
                .setSallary(cp.getSallary())
                .setHight(cp.getHeight())
                .setName(cp.getName())
                .setSurname(cp.getSurname())
                .setFriends(cp.getFriends())
                .createPerson();
        return person;
    }

    private BaseProperties generateBaseProperties() {
        final Gender gender = (new Random().nextBoolean()) ? W : M;
        final LocalDate birthDate = new RandomDate(minDate, maxDate).nextDate();
        final double fbRank = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        final int i = new Random().nextInt(Profession.values().length);
        final Profession profession = Profession.values()[i];
        final float iqRank = ThreadLocalRandom.current().nextInt(70, 140 + 1);
        final int c = new Random().nextInt(Country.values().length);
        final Country country = Country.values()[c];
        return new BaseProperties(gender, birthDate, iqRank, fbRank, profession, country);
    }
}
