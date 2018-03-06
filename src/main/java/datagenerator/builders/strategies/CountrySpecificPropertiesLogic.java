package datagenerator.builders.strategies;

import datagenerator.model.person.properties.BaseProperties;
import datagenerator.model.person.properties.CountrySpecificProperties;
import datagenerator.model.person.enums.Country;

import java.util.HashMap;
import java.util.Map;

public class CountrySpecificPropertiesLogic {

    private static Map<Country, ContinentStrategy> logic = new HashMap<>();
    private static NorthAmericaPropertiesStrategy napStrategy = new NorthAmericaPropertiesStrategy();
    private static AsianSpecificPropertiesStrategy asiaStrategy = new AsianSpecificPropertiesStrategy();
    private static SouthAmericaPropertiesStrategy southAmericaStrategy = new SouthAmericaPropertiesStrategy();

    static {
        logic.put(Country.USA, napStrategy);
        logic.put(Country.Canada, napStrategy);
        logic.put(Country.Russia, napStrategy);
        logic.put(Country.UK, napStrategy);
        logic.put(Country.Germany, napStrategy);
        logic.put(Country.France, napStrategy);
        logic.put(Country.Spain, southAmericaStrategy);
        logic.put(Country.Sweden, napStrategy);
        logic.put(Country.Denmark, napStrategy);
        logic.put(Country.Poland, napStrategy);
        logic.put(Country.Mexico, southAmericaStrategy);
        logic.put(Country.Holland, napStrategy);
        logic.put(Country.Columbia, southAmericaStrategy);
        logic.put(Country.Brasil, southAmericaStrategy);
        logic.put(Country.Venesuela, southAmericaStrategy);
        logic.put(Country.Chile, southAmericaStrategy);
        logic.put(Country.Kongo, napStrategy);
        logic.put(Country.RSA, napStrategy);
        logic.put(Country.Ethiopia, napStrategy);
        logic.put(Country.Slovakia, napStrategy);
        logic.put(Country.Hungary, napStrategy);
        logic.put(Country.Austria, napStrategy);
        logic.put(Country.Portugal, southAmericaStrategy);
        logic.put(Country.Israel, napStrategy);
        logic.put(Country.Iraq, napStrategy);
        logic.put(Country.Katar, napStrategy);
        logic.put(Country.SaudiArabia, napStrategy);
        logic.put(Country.China, asiaStrategy);
        logic.put(Country.SouthKorea, asiaStrategy);
        logic.put(Country.Japan, asiaStrategy);
        logic.put(Country.Thailand, asiaStrategy);
        logic.put(Country.Philipines, asiaStrategy);
        logic.put(Country.Vietnam, asiaStrategy);
    }

    public CountrySpecificProperties get(BaseProperties properties) {
        ICountrySpecificProperties specific = (ICountrySpecificProperties) logic.get(properties.getCountry());
        return specific.generate(properties);
    }
}
