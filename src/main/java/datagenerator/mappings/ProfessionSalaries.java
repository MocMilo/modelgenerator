package datagenerator.mappings;

import datagenerator.model.person.enums.Profession;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class ProfessionSalaries {
    private Map<Profession, BigDecimal> salaries = new HashMap<>();
    private Random random = new Random();

    public BigDecimal getSalary(Profession profession) {
        List<Profession> professions = Arrays.asList(Profession.values());
        int i;
        for (Profession item : professions) {
            i = random.nextInt(214);
            i++;
            salaries.put(item, new BigDecimal("1000.00").add(new BigDecimal(i))
                    .setScale(2, RoundingMode.HALF_EVEN));
        }
        return salaries.get(profession);
    }
}
