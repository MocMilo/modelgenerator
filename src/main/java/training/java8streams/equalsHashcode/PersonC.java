package training.java8streams.equalsHashcode;

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
}
