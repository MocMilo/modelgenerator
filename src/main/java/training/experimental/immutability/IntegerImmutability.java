package training.experimental.immutability;

import java.awt.*;

public class IntegerImmutability {
    public static void main(String[] args) {

        System.out.println("-- mutable point, immutable string ----");

        Point myPoint = new Point( 0, 0 );
        System.out.println( myPoint );
        myPoint.setLocation( 1.0, 0.0 );
        System.out.println( myPoint );

        String myString = new String( "old String" );
        System.out.println( myString );
        myString.replaceAll( "old", "new" );
        System.out.println( myString );

        Integer integer = 1;


        System.out.println("----------------");

        String a = "a";
        String b = "b";
        System.out.println(a);      // a
        System.out.println(a == b); // false

        a = b;                              // new value for a
        System.out.println(a);      // b
        System.out.println(a == b); // true - the same String in memory

        System.out.println("----------------");

        String aa = new String( "aa");
        String bb = new String( "bb");

        System.out.println(aa);       // aa
        System.out.println(aa == bb); // false

        aa = bb;
        System.out.println(aa);       // bb
        System.out.println(aa == bb); // true - the same String in memory

        aa.concat("_extension");
        System.out.println("aa after concat: " + aa);   // prints still just "bb"

        System.out.println("----------------");

        Integer x = 5;
        Integer y = 6;
        Integer z = x;
                x = y;

        System.out.println(x);   // 6
        System.out.println(z);   // 5
        System.out.println(x);   // 6

        System.out.println(x == y);       // true
        System.out.println(x.equals(y));  // true

        x = 6;

        System.out.println(x);            // 6
        System.out.println("----------------");

        Integer xx = new Integer(5);
        Integer yy = new Integer(6);
        Integer zz = xx;
        xx = yy;

        System.out.println(xx);   // 6
        System.out.println(zz);   // 5
        System.out.println(xx);   // 6

        System.out.println(xx == yy);       // true
        System.out.println(xx.equals(yy));  // true

        xx = 6;

        System.out.println(xx);             // 6
    }
}
