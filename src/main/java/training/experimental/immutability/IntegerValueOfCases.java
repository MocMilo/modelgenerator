package training.experimental.immutability;

public class IntegerValueOfCases {

    public static void main(String[] args) {

        System.out.println(Integer.valueOf(-129) == Integer.valueOf(-129)); // false
        System.out.println(Integer.valueOf(-128) == Integer.valueOf(-128)); // true
        System.out.println(Integer.valueOf(-127) == Integer.valueOf(-127)); // true

        System.out.println(Integer.valueOf(127) == Integer.valueOf(127));  // true
        System.out.println(Integer.valueOf(5) == Integer.valueOf(5));      // true
        System.out.println(Integer.valueOf(128) == Integer.valueOf(128));  // false

        /* reason Integer.valueOf(..) runs "Integer caching"

        Numbers between -128 and 127 are true  ( >127 and <-128 )  are false

        public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high){
           return IntegerCache.cache[i + (-IntegerCache.low)];
           return new Integer(i);
            }

        */

        Integer a = new Integer("10");
        Integer b = new Integer("10");

        Integer c = new Integer("10");
        Integer d = c;


        System.out.println("two new Integers a==b test:" + (a==b));  // false

        System.out.println("two Integers by reference d==c test:" + (d==c));  // true

    }


}
