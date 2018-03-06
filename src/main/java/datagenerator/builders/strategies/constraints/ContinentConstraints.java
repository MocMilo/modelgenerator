package datagenerator.builders.strategies.constraints;

import datagenerator.model.person.enums.BodyType;
import datagenerator.model.person.enums.EyesColour;
import datagenerator.model.person.enums.HairColour;

import java.math.BigDecimal;
import java.util.Set;

public class ContinentConstraints {

    private BigDecimal sallaryIndex;
    private int heightIndex;
    private BodyType bodyTypeIndex;
    private Set<HairColour> excludedHairColors;
    private Set<EyesColour> excludedEyesColors;

    public BigDecimal getSallaryIndex() {
        return sallaryIndex;
    }

    public int getHeightIndex() {
        return heightIndex;
    }

    public BodyType getBodyTypeIndex() {
        return bodyTypeIndex;
    }

    public Set<HairColour> getExcludedHairColors() {
        return excludedHairColors;
    }

    public Set<EyesColour> getExcludedEyesColors() {
        return excludedEyesColors;
    }

    public ContinentConstraints(BigDecimal sallaryIndex, int heightIndex, BodyType bodyTypeIndex, Set<HairColour> excludedHairColors, Set<EyesColour> excludedEyesColors) {
        this.sallaryIndex = sallaryIndex;
        this.heightIndex = heightIndex;
        this.bodyTypeIndex = bodyTypeIndex;
        this.excludedHairColors = excludedHairColors;
        this.excludedEyesColors = excludedEyesColors;
    }
}
