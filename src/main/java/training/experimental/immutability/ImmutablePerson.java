package training.experimental.immutability;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutablePerson {

    private final String name;
    private final int age;
    private final Point point;
    private List<Integer> numbers;
    private List<Point> points;

    public ImmutablePerson(String name, int age, Point point, List<Integer> numbers, List<Point> points) {
        this.name = name;
        this.age = age;
        this.point = new Point(point);
        this.numbers = new ArrayList<>(numbers);
        this.points = new ArrayList<>(points);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public final Point doMath(Point point) {
        System.out.println("point in: " + point.x + " " + point.y);
        point.x *= 10;
        point.y *= 100;
        System.out.println("point out: " + point.x + " " + point.y);
        return point;
    }

    public final Point doMathWithDefensiveCopy(Point p) {
        Point point = new Point(p);
        System.out.println("point in: " + point.x + " " + point.y);
        point.x *= 10;
        point.y *= 100;
        System.out.println("point out: " + point.x + " " + point.y);
        return point;
    }
}
