package softwareengineering_ae2.datastore;

import softwareengineering_ae2.CourseClasses.TeacherTrainingCourse;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// Placeholder Teacher Class
class MockTeacher{
    String name;
    boolean assigned;
    boolean trained;
}
// Placeholder Student Course Class
class MockSCR{
    boolean assigned;
}

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class FullData {
    List<MockSCR> studentCourse;
    List<TeacherTrainingCourse> teacherCourse;
    List<MockTeacher> teachers;

     List<MockSCR> getStudentCourse() {
        return studentCourse;
     }

     void setStudentCourse(List<MockSCR> studentCourse) {
        this.studentCourse = studentCourse;
     }

     List<TeacherTrainingCourse> getTeacherCourse() {
        return teacherCourse;
     }

     void setTeacherCourse(List<TeacherTrainingCourse> teacherCourse) {
        this.teacherCourse = teacherCourse;
     }

     List<MockTeacher> getTeachers() {
        return teachers;
     }

     void setTeachers(List<MockTeacher> teachers) {
        this.teachers = teachers;
     }
}


class Database {
    static private Path database;
    static private FullData fullDatabase;
    private static Database inst;
    private static ObjectMapper objMap;

    private static List<DatabaseOperations<?>> users;
     private Database() throws IOException {
        if(database == null) database = Paths.get("data/data.json");

        if(objMap == null) objMap = new ObjectMapper();

        if(fullDatabase == null) fullDatabase = objMap.readValue(database.toFile(), FullData.class);

        // Make sure to write data on exit
        Runtime.getRuntime().addShutdownHook(new Thread() {
             public void run() {
                 try {
                     for(var user:users){
                         user.update();
                     }

                     write();
                 } catch (IOException e) { // TODO: More graceful exit
                     e.printStackTrace();
                 }}});
    }

    static Database getInstance()throws IOException {
         if(inst == null) inst = new Database();
         return inst;
    }
    FullData data(){
         return fullDatabase;
    }
    void registerUser(DatabaseOperations<?> user){
         users.add(user);
    }
    void write() throws IOException {
         objMap.writeValue(database.toFile(),fullDatabase);
    }
}
