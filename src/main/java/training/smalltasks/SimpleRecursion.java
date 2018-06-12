package training.smalltasks;

public class SimpleRecursion {
    public static void main(String[] args) {

        print("Happy Birthday", 10);
    }

    public static void print(String string, int limit) {
        if (limit == 0) {   // escape condition first
            return;
        }
        print(string, limit - 1); // recursive call
        System.out.println(string + " iteration: " + limit);
    }
}
