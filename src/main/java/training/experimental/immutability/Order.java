package training.experimental.immutability;

import java.awt.*;
import java.util.List;

public class Order {

    List<Point> points;
    private List<Point> getterPoints;

    final List<Point> finalPoints;


    public Order(List<Point> points, List<Point> finalPoints) {
        this.points = points;
        this.finalPoints = finalPoints;
    }

    public List<Point> getGetterPoints() {
        return getterPoints;
    }
}
