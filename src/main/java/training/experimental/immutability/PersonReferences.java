package training.experimental.immutability;

import java.awt.*;

public class PersonReferences {

    public static void main(String[] args) {
        System.out.println("case 1");
        case1();
        System.out.println("case 2");
        case2();
    }

    private static void case1() {
        MutablePerson personA = new MutablePerson("xxx", new StringBuilder("sss"), 25, new Point(1, 2));
        MutablePerson personB = new MutablePerson("zzz", new StringBuilder("bbb"), 26, new Point(2, 2));

        System.out.println("personA " + personA.getName());
        System.out.println("personA " + personA.getMutableString().toString());
        System.out.println("personA " + personA.getAge());
        System.out.println("personA " + personA.getPoint());
        System.out.println("personB " + personB.getName());
        System.out.println("personB " + personB.getMutableString().toString());
        System.out.println("personB " + personB.getAge());
        System.out.println("personB " + personB.getPoint());

        switchMethod(personA, personB);

        System.out.println("personB " + personB.getName());  // no changes in PersonB
        System.out.println("personB " + personB.getMutableString().toString());
        System.out.println("personB " + personB.getAge());
        System.out.println("personB " + personB.getPoint());
    }

    private static void case2() {
        MutablePerson person = new MutablePerson("xxx", new StringBuilder("sss"), 25, new Point(1, 2));

        System.out.println("PersonB before switch: " + person.getName());

        mutatingMethod(person);

        System.out.println("PersonA after switch: " + person.getName());
    }


    private static void switchMethod(MutablePerson personA, MutablePerson personB) {
        personB = personA;

        System.out.println("personB in switch method:" + personB.getName());  // b.getName() prints xxx
    }

    private static void mutatingMethod(MutablePerson person) {
        person.getName().concat("_concatStingTry");                           //
        person.getMutableString().append("_appendSbTry");

        System.out.println("String mutability check: " + person.getName());   // ok String immutable !
        System.out.println("SB mutability check: " + person.getMutableString().toString());   // ok SB mutable!

        // setting new value to String;
        person.setName("new Name zzz");

        System.out.println("personB in switch method:" + person.getName());  // b.getName() prints xxx
    }

}
