package training.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import datagenerator.model.person.Person;
import training.java8streams.approach1.FileUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get(ClassLoader.getSystemClassLoader()
                .getResource("example_container.json")
                .getPath());

        System.out.println(path);

        String s = new String(Files.readAllBytes(path));
        System.out.println(s);

        List<Person> personList = new FileUtil().getTasksModel();
        System.out.println("personListSize: " + personList.size());

        Person p = personList.get(0);

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("chosen person json" + objectMapper.writeValueAsString(p));
        String json =  objectMapper.writeValueAsString(p);


        try (FileOutputStream fout = new FileOutputStream("/tmp/person.ser");
             ObjectOutputStream obout = new ObjectOutputStream(fout)) {
            obout.writeObject(p);


        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream("/tmp/person.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Person personFormFis = (Person) ois.readObject();
            System.out.println("Fis Person" + personFormFis.getName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
