package datagenerator.builders;

import datagenerator.model.person.names.FemaleNames;
import datagenerator.model.person.names.MaleNames;
import datagenerator.model.person.names.PersonNamesContainer;
import datagenerator.model.person.names.Surnames;

import java.util.Arrays;

public class PersonNamesBuilder {

    private PersonNamesContainer namesContainer = new PersonNamesContainer();

    public PersonNamesContainer get(){

        FemaleNames femaleNames = new FemaleNames();
        femaleNames.setAsianNames(Arrays.asList("Akemi", "Asha", "Azumi", "Kayo", "Ki"));
        femaleNames.setNorthAmericaNemes(Arrays.asList("Alice", "Jenifer", "Jane", "Sandy", "April"));
        femaleNames.setSouthAmericaNames(Arrays.asList("Camilla", "Celia", "Constance", "Diana", "April"));
        femaleNames.setAfricaNames(Arrays.asList("Afua", "Chipo", "Furaha", "Masika", "Subira"));
        femaleNames.setMiddleEastNames(Arrays.asList("Adilah", "Amira", "Bahirah", "Daphne", "Hadassah"));

        MaleNames maleNames = new MaleNames();
        maleNames.setAsianNames(Arrays.asList("Liu", "Jet", "Bruce", "Jin", "Jackie"));
        maleNames.setNorthAmericaNemes(Arrays.asList("John", "Tom", "Stanley", "Kevin", "Andrew"));
        maleNames.setSouthAmericaNames(Arrays.asList("Felipe", "Diego", "Adriano", "Augusto", "Benito"));
        maleNames.setAfricaNames(Arrays.asList("Tuma", "Zaire", "Obasi", "Mosi", "Kanye"));
        maleNames.setMiddleEastNames(Arrays.asList("Abdul", "Ansar", "Farhaan", "Khurram", "Mehtar"));

        Surnames surnames = new Surnames();
        surnames.setAsianSurnames(Arrays.asList("Chiu", "Lee", "Chan", "Wong", "Zoeng"));
        surnames.setNorthAmericaSurnames(Arrays.asList("Smith", "Kovalsky", "Musk", "Gates", "Kubrick"));
        surnames.setSouthAmericaSurnames(Arrays.asList("Rodrigez", "Cortez", "Angulis", "Bellasis", "Ferbras"));
        surnames.setAfricaNames(Arrays.asList("Azikiwe", "Obasanjo", "Achebe", "Jakande", "Mbadinuju"));
        surnames.setMiddleEastNames(Arrays.asList("Kattan", "Shamoun", "Haddad", "Bishara", "Totah"));

        PersonNamesContainer namesContainer = new PersonNamesContainer();
        namesContainer.setFemaleNames(femaleNames);
        namesContainer.setMaleNames(maleNames);
        namesContainer.setSurnames(surnames);
        return namesContainer;
    }

}
