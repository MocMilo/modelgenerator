package training.experimental.immutability;

public class ReferencesToMethodArguments {
    public static void main(String[] args) {
        System.out.println("-- case 0 ----");
        case0();
        System.out.println("-- case 1 ----");
        case1();
        System.out.println("-- case 2 ----");
        case2();
        System.out.println("-- case 3 ----");
        case3();
        System.out.println("-- case 4 ----");
        case4();
    }

    private static void switchIntsWithoutTemp(int a, int b) {
        System.out.println("switchIntsWithoutTemp");
        b = a;
        System.out.println("b inside switch method:" + b); // prints 10 here, outside method b = 20
    }

    private static void switchInts(int a, int b) {
        System.out.println("switchInts");
        int temp = a;
        a = b;
        b = temp;
        System.out.println("b inside switch method:" + b);
    }

    private static void switchIntegers(Integer a, Integer b) {
        System.out.println("switchIntegers");
        Integer temp = a;
        a = b;
        b = temp;
        System.out.println("b inside switch method:" + b);
    }

    private static Integer switchIntegersReturn(Integer a, Integer b) {
        System.out.println("switchIntegersReturn (with return b)");
        Integer temp = a;
        a = b;
        b = temp;
        return b;
    }

    private static void case0() {
        int a = 10;
        int b = 20;

        System.out.println("a = " + a + " before int switch"); // a = 10
        System.out.println("b = " + b + " before int switch"); // b = 20

        switchIntsWithoutTemp(a, b);

        System.out.println("a = " + a + " after switch without local variable temp"); // a = 10
        System.out.println("b = " + b + " after switch without local variable temp"); // b = 20

    }


    private static void case1() {
        int a = 10;
        int b = 20;

        System.out.println("a = " + a + " before int switch"); // a = 10
        System.out.println("b = " + b + " before int switch"); // b = 20

        switchInts(a, b);

        System.out.println("a = " + a + " after switch by reference"); // a = 10
        System.out.println("b = " + b + " after switch by reference"); // b = 20

        b = a;
        System.out.println("b = a , now b = " + b + " just in main code");  // b = 10
    }


    private static void case2() {
        Integer a = 10;
        Integer b = 20;
        System.out.println("a = " + a + " before switch"); // a = 10
        System.out.println("b = " + b + " before switch"); // b = 20

        switchIntegers(a, b);

        System.out.println("a = " + a + " by reference"); // a = 10
        System.out.println("b = " + b + " by reference"); // b = 20

        b = a;
        System.out.println("b = a , now b = " + b + " just in code");  // b = 10


    }

    private static void case3() {
        Integer a = 10;
        Integer b = 20;
        System.out.println("a = " + a + " before switch"); // a = 10
        System.out.println("b = " + b + " before switch"); // b = 20

        System.out.println("b = " + switchIntegersReturn(a, b) + " by return"); // by return b = 10
    }

    private static void case4() {

        Integer a = new Integer(10);  // no difference
        Integer b = new Integer(20);  // no difference

        System.out.println("a = " + a + " before switch"); // a = 10
        System.out.println("b = " + b + " before switch"); // b = 20

        switchIntegers(a, b);

        System.out.println("a = " + a + " by reference");  // a = 10
        System.out.println("b = " + b + " by reference");  // b = 20

        System.out.println("b = " + switchIntegersReturn(a, b) + " by return"); // by return b = 10
    }


}
