package training.mapoperations;

import datagenerator.model.person.Person;
import training.java8streams.approach1.FileUtil;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MapOperations {

    public static void main(String[] args) throws IOException {
        Map<Integer, Person> personMap = new HashMap<>();
        List<Person> people = new FileUtil().getTasksModel();

/*        people.forEach( x -> {
            x.setId(1);
        });*/

        System.out.println(people.size());




        for(int i = 0; i <  people.size(); i++){
            personMap.put(i, people.get(i));
        }

        System.out.println(personMap.size());
        System.out.println(personMap.entrySet());

        personMap.entrySet().stream().collect(Collectors.toList()).forEach(x ->{ System.out.println(x);});

        personMap.entrySet().stream()
                .map(x -> x.getValue())
                .collect(Collectors.toList());

        System.out.println("+++++++++++++");
        new ArrayList<>(personMap.values()).forEach(System.out::println);

    }
}
