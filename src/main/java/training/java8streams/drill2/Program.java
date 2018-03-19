package training.java8streams.drill2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import datagenerator.builders.PersonContainerBuilder;
import datagenerator.model.person.PersonContainer;

import java.io.File;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        PersonContainer container = new PersonContainerBuilder().getContainer();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.writeValue(new File("/home/star/example_container.json"), container);

        //TODO generate Person List to file and read from it

        PersonContainer desCont = mapper.readValue(new File("/home/star/example_container.json"), PersonContainer.class);

        System.out.println(desCont.getPeopleList().size());
    }
}
