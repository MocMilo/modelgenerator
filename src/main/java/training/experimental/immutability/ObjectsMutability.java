package training.experimental.immutability;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsMutability {

    public static void main(String[] args) {

        List<Integer> inetgers = new ArrayList<>(Arrays.asList(1, 2, 3));
        Point point = new Point(1, 1);  // Point is mutable
        Point point1 = new Point(2, 2);


        List<Point> points = new ArrayList<>();
        points.add(point);
        points.add(point1);

        ImmutablePerson person = new ImmutablePerson("xyz", 25, point, inetgers, points);

        // TRYING TO BREAK "IMMUTABLE PERSON"
        // person.getNumbers().remove(0);         // throws UnsupportetOperation exception in runtime
        person.getName().concat("ee");            // name is String immutable
        // person.getAge()....                    // no methods, small int cannot change
        person.getPoints().get(0).x = 99;         // point is mutable

        System.out.println("object before doMath() " + point1);              // before math

        person.doMath(point1);                                               // doMath()

        System.out.println("changed by reference after doMath() " + point1); // after math

        System.out.println("----- defensive copy --------");

        System.out.println("object before doMathWithDefensiveCopy() " + point1);              // before math

        person.doMathWithDefensiveCopy(point1);                              // doMath()

        System.out.println("not changed by reference after doMathWithDefensiveCopy() " + point1); // after math

        System.out.println(person.getName());
        System.out.println(person.getNumbers());
        System.out.println(person.getPoints().get(0));  // is x = 99  point was changed!
    }
}
