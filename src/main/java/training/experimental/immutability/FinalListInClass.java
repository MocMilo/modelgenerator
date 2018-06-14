package training.experimental.immutability;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class FinalListInClass {

    public static void main(String[] args) {
        Point p = new Point(0, 0);
        Point p1 = new Point(1, 1);

        List<Point> pointList = new ArrayList<>();
        pointList.add(p);
        pointList.add(p1);

        List<Point> pointList2 = new ArrayList<>();
        pointList2.add(p);
        pointList2.add(p1);

        List<Point> pointList3 = new ArrayList<>();
        pointList3.add(p1);
        pointList3.add(p1);

        Order order = new Order(pointList, pointList2);
        order.points = new ArrayList<>();

        // order.finalPoints = new ArrayList<>(); // finalPoints are final so it will not compile
        // order.getGetterPoints() = new ArrayList<>(); when list accessed by getter it will not compile
    }
}
