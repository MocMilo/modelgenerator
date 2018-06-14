package training.experimental.immutability;

import java.awt.*;

public class MutablePerson {

    private String name;
    private StringBuilder mutableString;
    private int age;
    private Point point;

    public MutablePerson(String name, StringBuilder mutableString, int age, Point point) {
        this.name = name;
        this.mutableString = mutableString;
        this.age = age;
        this.point = point;
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

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public StringBuilder getMutableString() {
        return mutableString;
    }

    public void setMutableString(StringBuilder mutableString) {
        this.mutableString = mutableString;
    }
}
