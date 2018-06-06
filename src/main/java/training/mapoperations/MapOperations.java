package training.mapoperations;

import datagenerator.model.person.Person;
import training.java8streams.approach1.FileUtil;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MapOperations {

    public static void main(String[] args) throws IOException {
        Map<String, Person> personMap = new HashMap<>();
        List<Person> people = new FileUtil().getTasksModel();

/*        people.forEach( x -> {
            x.setId(1);
        });*/

        System.out.println(people.size());

        for(int i = 0; i <  people.size(); i++){
            String s = "xyzzzz"+i;
            personMap.put(s, people.get(i));
        }

        System.out.println(personMap.size());
        System.out.println(personMap.entrySet());

        personMap.entrySet().stream().collect(Collectors.toList()).forEach(x ->{ System.out.println(x);});

        personMap.entrySet().stream()
                .map(x -> x.getValue())
                .collect(Collectors.toList());

        System.out.println("###########");
        new ArrayList<>(personMap.values()).forEach(System.out::println);
        System.out.println("***********");

        // mapa ma w key hashcode. Jeżeli typem key jest integer to jest to ten integer,
        // jeżeli typem jest np. string, to key jest również intigerem (wyliczony hashcode z tego
        // Stringa)
        new ArrayList<>(personMap.keySet()).forEach(x -> System.out.println(x.hashCode()));


    }
}
