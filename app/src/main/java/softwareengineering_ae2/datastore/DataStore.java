package softwareengineering_ae2.datastore;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;
import java.util.Map;

import static softwareengineering_ae2.datastore.attribute.*;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class MockPerson {
    private String name;
    private String job;

    String get_cont(){
        return "Person:: Name : " + name + " Job : " + job;
    }
}
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class MockCourse{
    private String name;
    private String desc;

    String get_cont(){
        return "Course:: Name: " + name + " Desc: " + desc;
    }
}

enum attribute {
    Assigned,
    Trained;

}

public class DataStore {
    static protected Path database;
    static private JsonNode fullTree;

    public DataStore() throws IOException {
        database = Paths.get("data/data.json");
        System.out.println("Path " + database.toAbsolutePath());
        fullTree = new ObjectMapper().readTree(database.toFile());
    }
    public JsonNode treeHead() throws JsonProcessingException {
        Iterator<Map.Entry<String, JsonNode>> it = fullTree.fields();
        return null;
    }
}
