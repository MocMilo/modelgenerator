package datagenerator.builders.strategies;

import datagenerator.model.person.properties.BaseProperties;
import datagenerator.model.person.properties.CountrySpecificProperties;
import datagenerator.model.person.enums.Country;

import java.util.HashMap;
import java.util.Map;

public class CountrySpecificPropertiesLogic {

    private static Map<Country, ContinentStrategy> logic = new HashMap<>();
    private static NorthAmericaPropertiesStrategy napStrategy = new NorthAmericaPropertiesStrategy();
    private static AsianSpecificPropertiesStrategy apStrategy = new AsianSpecificPropertiesStrategy();
    private static SouthAmericaPropertiesStrategy sapStrategy = new SouthAmericaPropertiesStrategy();
    private static AfricaPropertiesStrategy afpStrategy = new AfricaPropertiesStrategy();
    private static MiddleEastPropertiesStrategy meStrategy = new MiddleEastPropertiesStrategy();

    static {
        logic.put(Country.USA, napStrategy);
        logic.put(Country.Canada, napStrategy);
        logic.put(Country.Russia, napStrategy);
        logic.put(Country.UK, napStrategy);
        logic.put(Country.Germany, napStrategy);
        logic.put(Country.France, napStrategy);
        logic.put(Country.Spain, sapStrategy);
        logic.put(Country.Sweden, napStrategy);
        logic.put(Country.Denmark, napStrategy);
        logic.put(Country.Poland, napStrategy);
        logic.put(Country.Mexico, sapStrategy);
        logic.put(Country.Holland, napStrategy);
        logic.put(Country.Columbia, sapStrategy);
        logic.put(Country.Brasil, sapStrategy);
        logic.put(Country.Venesuela, sapStrategy);
        logic.put(Country.Chile, sapStrategy);
        logic.put(Country.Kongo, afpStrategy);
        logic.put(Country.RSA, afpStrategy);
        logic.put(Country.Ethiopia, afpStrategy);
        logic.put(Country.Slovakia, napStrategy);
        logic.put(Country.Hungary, napStrategy);
        logic.put(Country.Austria, napStrategy);
        logic.put(Country.Portugal, sapStrategy);
        logic.put(Country.Israel, meStrategy);
        logic.put(Country.Iraq, meStrategy);
        logic.put(Country.Katar, meStrategy);
        logic.put(Country.SaudiArabia, meStrategy);
        logic.put(Country.China, apStrategy);
        logic.put(Country.SouthKorea, apStrategy);
        logic.put(Country.Japan, apStrategy);
        logic.put(Country.Thailand, apStrategy);
        logic.put(Country.Philipines, apStrategy);
        logic.put(Country.Vietnam, apStrategy);
    }

    public CountrySpecificProperties get(BaseProperties properties) {
        ICountrySpecificProperties specific = (ICountrySpecificProperties) logic.get(properties.getCountry());
        return specific.generate(properties);
    }
}
