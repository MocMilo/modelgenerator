package training.java8streams.equalsHashcode;

import java.util.Objects;

public class PersonC {

    private int Id;
    private String surname;
    private int height;

    public PersonC(int id, String surname, int height) {
        Id = id;
        this.surname = surname;
        this.height = height;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonC personC = (PersonC) o;
        return Id == personC.Id &&
                height == personC.height &&
                Objects.equals(surname, personC.surname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Id, surname, height);
    }
}
