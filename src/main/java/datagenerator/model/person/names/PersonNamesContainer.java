package datagenerator.model.person.names;

public class PersonNamesContainer {
    private FemaleNames femaleNames;
    private MaleNames maleNames;
    private Surnames surnames;

    public FemaleNames getFemaleNames() {
        return femaleNames;
    }

    public void setFemaleNames(FemaleNames femaleNames) {
        this.femaleNames = femaleNames;
    }

    public MaleNames getMaleNames() {
        return maleNames;
    }

    public void setMaleNames(MaleNames maleNames) {
        this.maleNames = maleNames;
    }

    public Surnames getSurnames() {
        return surnames;
    }

    public void setSurnames(Surnames surnames) {
        this.surnames = surnames;
    }
}
