package training.java8streams.approach1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import datagenerator.builders.PersonContainerBuilder;
import datagenerator.builders.PersonNamesBuilder;
import datagenerator.model.person.Person;
import datagenerator.model.person.PersonContainer;
import datagenerator.model.person.names.PersonNamesContainer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileUtil {

    private ClassLoader classLoader = getClass().getClassLoader();

    public List<Person> getTasksModel() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        File destFile  = new File(classLoader.getResource("example_container.json").getFile());
        PersonContainer desCont = mapper.readValue(destFile, PersonContainer.class);
        return desCont.getPeopleList();
    }

    public void saveModelFile() throws IOException {
        PersonContainer generatedContainer = new PersonContainerBuilder().getContainer();
        File destFile = new File("/home/star/example_container.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.writeValue(destFile, generatedContainer);
    }

    public void savePersonNamesContainerToFile() throws IOException {
        PersonNamesContainer personNamesContainer = new PersonNamesBuilder().get();

        File destFile = new File("/home/star/names.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(destFile, personNamesContainer);
    }
}
