package training.experimental.immutability;

import java.awt.*;

public class StringVsPoint {

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
    }
}
