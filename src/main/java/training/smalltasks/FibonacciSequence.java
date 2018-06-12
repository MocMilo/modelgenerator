package training.smalltasks;

import java.util.Arrays;

public class FibonacciSequence {
    public static int[] fibByRec(int num) {
        int fib[] = new int[num];

        for (int i = 0; i < num; i++) {
            fib[i] = fibRec(i);
        }

        return fib;
    }

    public static int fibRec(int n)  {
        if (n < 2) return n;
        return fibRec(n - 1) + fibRec(n - 2);
    }

    public static void main(String[] args) {

        // generate 10 Fibonacci numbers:
        Arrays.stream(fibByRec(10)).forEach(System.out::println);
    }
}
