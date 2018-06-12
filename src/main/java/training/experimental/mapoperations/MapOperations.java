package training.experimental.mapoperations;

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

        for (int i = 0; i < people.size(); i++) {
            String s = "xyzzzz" + i;
            personMap.put(s, people.get(i));
        }

        System.out.println(personMap.size());
        System.out.println(personMap.entrySet());



        personMap.entrySet().stream().collect(Collectors.toList()).forEach(x -> {
            System.out.println(x);
        });

        personMap.entrySet().stream()
                .map(x -> x.getValue())
                .collect(Collectors.toList());

        System.out.println("###########");
        new ArrayList<>(personMap.values()).forEach(System.out::println);
        System.out.println("***********");

        new ArrayList<>(personMap.keySet()).forEach(x -> System.out.println(x));

        System.out.println("ARRAY LIST ADD/REMOVE");
        List<Person> personList = new ArrayList<>(new FileUtil().getTasksModel());
        Person person = personList.get(0);
        System.out.println("before person from 0 " + person.getName());
        System.out.println("before add person to 10, [10] " + personList.get(10).getName());
        System.out.println("before add person to 10, [11] " + personList.get(11).getName());
        System.out.println("before add person to 10, [12] " + personList.get(12).getName());
        personList.add(10, person);
        System.out.println("after add person to 10, [10] " + personList.get(10).getName());
        System.out.println("after add person to 10, [11] " + personList.get(11).getName());
        System.out.println("after add person to 10, [12] " + personList.get(12).getName());
        personList.remove(10);
        System.out.println("after remove person from 10, [10] " + personList.get(10).getName());
        System.out.println("after remove person from 10, [11] " + personList.get(11).getName());
        System.out.println("after remove person from 10, [12] " + personList.get(12).getName());
        System.out.println("after person List size " + personList.size());
        personList.set(12, person);
        System.out.println("after person set at 12, [12] " + personList.get(12).getName());


        System.out.println("LINKED LIST ADD/REMOVE");

        List<Person> personList2 = new LinkedList<>(new FileUtil().getTasksModel());
        Person person2 = personList2.get(0);
        System.out.println("before person from 0 " + person2.getName());
        System.out.println("before add person to 10, [10] " + personList2.get(10).getName());
        System.out.println("before add person to 10, [11] " + personList2.get(11).getName());
        System.out.println("before add person to 10, [12] " + personList2.get(12).getName());
        personList2.add(10, person);
        System.out.println("after add person to 10, [10] " + personList2.get(10).getName());
        System.out.println("after add person to 10, [11] " + personList2.get(11).getName());
        System.out.println("after add person to 10, [12] " + personList2.get(12).getName());
        personList2.remove(10);
        System.out.println("after remove person from 10, [10] " + personList2.get(10).getName());
        System.out.println("after remove person from 10, [11] " + personList2.get(11).getName());
        System.out.println("after remove person from 10, [12] " + personList2.get(12).getName());
        System.out.println("after person List size " + personList2.size());

        personList.set(12, person);
        System.out.println("after person set at 12, [12] " + personList.get(12).getName());

        Set<Person> personSet = new HashSet<>(personList2);
        System.out.println("person set size: " + personSet.size());

        personSet.contains(person2);

        for (Person p : personSet){
            p.getName();
        }

        personMap.putIfAbsent("xyz", person);





    }
}
