package datagenerator.builders.strategies;

import datagenerator.model.person.properties.BaseProperties;
import datagenerator.model.person.properties.CountrySpecificProperties;

public interface ICountrySpecificProperties {

    CountrySpecificProperties generate(BaseProperties baseProperties);
}
