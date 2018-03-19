package training.java8streams.equalsHashcode;

import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        /*
         *  "Two equal objects must have equal hashcode
         *  two same hashcodes dosn't mean the objects are equal."
         */

        // two objects of the same class PersonA
        // (objects with the same values)

        PersonA p1 = new PersonA(1, "Danny", 20);
        PersonA p2 = new PersonA(1, "Danny", 20);

        // object of different class PersonB but with the same implementation
        // (the same fields with the same values)
        PersonB pB = new PersonB(1, "Danny", 20);

        // PersonA and PersonB have .equal and hashcode implemented

        System.out.println("p1 == p2 check:" + (p1 == p2));          // false (different objects
        // of the same type  in memory)

        System.out.println("p1 equals p2 check: " + p1.equals(p2));  // true  (same type and values)
        System.out.println("p1 equals p3 check: " + p1.equals(pB));  // false (same values but different type)

        System.out.println("p1 hashcode:" + p1.hashCode());  // p1 hashcode:2039781048
        System.out.println("pB hashcode:" + pB.hashCode());  // p3 hashcode:2039781048

        // the same class object but different values:
        p1.setId(2);
        System.out.println("p1 hashcode:" + p1.hashCode());  // p1 hashcode:2039782009


        Set<BasePerson> check = new HashSet<>();
        check.add(p1);
        //check.add(p1);
        check.add(pB);
        System.out.println("check set size: " + check.size());


        // immutable / mutable
        Integer i  = 5;
        PersonB personB = new PersonB(1, "Alice", 5);

        System.out.println("integer before method: "+ i.hashCode());
        System.out.println("personB before method: "+ personB.hashCode());

        changerOne(personB);
        changerTwo(i);
        System.out.println("check age of personB: " +personB.getAge());
        System.out.println("check integer i: " +i);

        System.out.println("PersonB after method: " +personB.hashCode());

        System.out.println("string hashcode:" + new String("xyz").hashCode());
        System.out.println("string hashcode:" + new String("xyz").hashCode());

    }

    private static void changerOne(PersonB personB){
        personB.setAge(55);
    }

    private static void changerTwo(Integer i){
        i = 55;
        System.out.println("integer inside method after change: "+ i.hashCode());
    }


}
