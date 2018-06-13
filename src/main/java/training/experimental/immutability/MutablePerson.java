package training.experimental.immutability;

import java.util.List;

public class MutablePerson {

    private String name;
    private int age;
    private List<Integer> numbers;

    public MutablePerson(String name, int age, List<Integer> numbers) {
        this.name = name;
        this.age = age;
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
