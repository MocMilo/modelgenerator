package datagenerator.builders.strategies;

import datagenerator.mappings.ProfessionSalaries;
import datagenerator.model.person.properties.BaseProperties;
import datagenerator.model.person.Person;
import datagenerator.model.person.enums.BodyType;
import datagenerator.model.person.enums.EyesColour;
import datagenerator.model.person.enums.HairColour;
import datagenerator.model.person.properties.CountrySpecificProperties;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


import static datagenerator.model.person.enums.Gender.W;

public class AsianSpecificPropertiesStrategy extends ContinentStrategy
        implements ICountrySpecificProperties {

    private static final BigDecimal SALLARY_INDEX = new BigDecimal("0.65");
    private static final int HEIGHT_INDEX = 8;

    private List<String> manNames = Arrays.asList("Liu", "Jet", "Bruce", "Jin", "Jackie");
    private List<String> womanNames = Arrays.asList("Akemi", "Asha", "Azumi", "Kayo", "Ki");
    private List<String> surnames = Arrays.asList("Chiu", "Lee", "Chan", "Wong", "Zoeng");

    @Override
    public CountrySpecificProperties generate(BaseProperties properties) {
        final BigDecimal salary = new ProfessionSalaries().getSalary(properties.getProfession());
        return new CountrySpecificProperties(
                this.generateEyesColor(),
                this.generateHairColor(),
                this.generateBodyType(),
                salary.multiply(SALLARY_INDEX).setScale(2, RoundingMode.HALF_EVEN),
                this.generateHeight(properties),
                this.generateName(properties),
                this.generateSurname(),
                new HashSet<Person>());
    }

    private String generateName(BaseProperties properties) {
        return properties.getGender().equals(W) ?
                womanNames.get(new Random().nextInt(womanNames.size())) :
                manNames.get(new Random().nextInt(manNames.size()));
    }

    private String generateSurname() {
        return surnames.get(new Random().nextInt(surnames.size()));
    }

    private int generateHeight(BaseProperties properties) {
        int correction = (properties.getGender().equals(W) ? HEIGHT_INDEX : 0);
        return ThreadLocalRandom.current().nextInt(140 - correction, 175 - correction);
    }

    private HairColour generateHairColor() {
        List<HairColour> availableHair = new ArrayList<>(Arrays.asList(HairColour.values()));
        availableHair.remove(HairColour.Blond);
        availableHair.remove(HairColour.BrightBlond);
        final int i = new Random().nextInt(availableHair.size());
        return availableHair.get(i);
    }

    private EyesColour generateEyesColor() {
        List<EyesColour> availableEyesColors = new ArrayList<>(Arrays.asList(EyesColour.values()));
        availableEyesColors.remove(EyesColour.blue);
        availableEyesColors.remove(EyesColour.grey);
        final int i = new Random().nextInt(availableEyesColors.size());
        return availableEyesColors.get(i);
    }

    private BodyType generateBodyType() {
        List<BodyType> availableBodyTypes = new ArrayList<>(Arrays.asList(BodyType.values()));
        availableBodyTypes.remove(BodyType.VERY_FAT);
        availableBodyTypes.remove(BodyType.FAT);
        final int i = new Random().nextInt(availableBodyTypes.size());
        return availableBodyTypes.get(i);
    }
}
