package training.experimental.mapoperations;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PersonAsKeyMapTest {

    public static void main(String[] args) {

        // Map as class idea extension
/*
        Map<Class<? extends Product>, Supplier<PricingStrategy>> map = new HashMap<>();
        map.put(new Product() {}, () -> (PricingStrategy) () -> null);*/

        // public getGenerator(Product p){
        // map.get(p.getClass()).get();       //
        // }

        // Person as Key

        Map<PersonAsKey, String> test = new HashMap<>();
        PersonAsKeyMapTest personAsKeyMapTest = new PersonAsKeyMapTest();

        PersonAsKey personAsKey = personAsKeyMapTest.new PersonAsKey();
        personAsKey.age = 25;

        System.out.println(personAsKey.hashCode());

        test.put(personAsKey, "test");

        personAsKey.age = 26;

        System.out.println("hashcode after set new age:" + personAsKey.hashCode());

        // personAsKey.age = 25;

        System.out.println("string form map by Person: " + test.get(personAsKey));  // person is null
        // not found
        // hashcode

    }

    private class PersonAsKey {
/*     final String name ="";
       final int age = 0;*/

        String name = "";
        int age = 0;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PersonAsKey that = (PersonAsKey) o;
            return age == that.age &&
                    Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }


}
