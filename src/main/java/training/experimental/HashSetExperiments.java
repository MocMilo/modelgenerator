package training.experimental;

import training.java8streams.equalsHashcode.BasePerson;
import training.java8streams.equalsHashcode.PersonA;
import training.java8streams.equalsHashcode.PersonB;

import java.util.HashSet;
import java.util.Set;

public class HashSetExperiments {


    public static void main(String[] args) {


        Set<BasePerson> personSet = new HashSet<>();

        PersonA personA = new PersonA(1,"aaa", 25); //
        PersonB personB = new PersonB(1,"aaa", 25);

        // the same hashcode when different types
        System.out.println(personA.hashCode());
        System.out.println(personB.hashCode());

        System.out.println(personA.equals(personB));

        personSet.add(personA);
        personSet.add(personB);

        System.out.println(personSet.size());



    }

}
