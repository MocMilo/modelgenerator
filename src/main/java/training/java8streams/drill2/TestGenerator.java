package training.java8streams.drill2;

import datagenerator.builders.PersonGenerator;
import datagenerator.model.person.Person;

public class TestGenerator {
    public static void main( String[]args){
        for (int i = 0; i < 10000 ; i++) {
            Person random = new PersonGenerator().generate(i);
            System.out.println(random.toString());
        }
    }
}
