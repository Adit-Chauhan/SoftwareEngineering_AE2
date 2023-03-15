package softwareengineering_ae2.datastore;

import softwareengineering_ae2.CourseClasses.StudentCourseRequirements;
import softwareengineering_ae2.CourseClasses.TeacherTrainingCourse;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import softwareengineering_ae2.PersonClasses.Teacher;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
* This entire class only has package protected or private visibility to prevent any other class to create get an
* instance of Database class that can directly access data.
*
* */
// Placeholder Teacher Class

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class FullData {
    List<StudentCourseRequirements> studentCourse;
    List<TeacherTrainingCourse> teacherCourse;
    List<Teacher> teachers;

     List<StudentCourseRequirements> getStudentCourse() {
        return studentCourse;
     }

     void setStudentCourse(List<StudentCourseRequirements> studentCourse) {
        this.studentCourse = studentCourse;
     }

     List<TeacherTrainingCourse> getTeacherCourse() {
        return teacherCourse;
     }

     void setTeacherCourse(List<TeacherTrainingCourse> teacherCourse) {
        this.teacherCourse = teacherCourse;
     }

     List<Teacher> getTeachers() {
        return teachers;
     }

     void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
     }
}


class Database {
    static private Path database;
    static private FullData fullDatabase;
    private static Database inst;
    private static ObjectMapper objMap;

    // Allow any subtype that implements DatabaseOperations
    private static List<BaseStore<?>> users;
     private Database() throws IOException {
        if(database == null) database = Paths.get("data/data.json");

        if(objMap == null) objMap = new ObjectMapper();

        if(fullDatabase == null) fullDatabase = objMap.readValue(database.toFile(), FullData.class);

        if(users == null) users = new ArrayList<>();
        // Setup the Shutdown Hood
        Runtime.getRuntime().addShutdownHook(new Thread() {
             public void run() {
                 try {
                     // Update the main database with the local copies of data
                     for(var user:users){
                         user.update();
                     }
                    // Write Data to file
                     write();
                 } catch (IOException e) { // TODO: More graceful exit
                     e.printStackTrace();
                 }}});
    }
    // Make Database singleton
    // Make sure that only classes that implement DatabaseOperations can get an instance
    static Database getInstance(BaseStore<?> usr)throws IOException {
         if(inst == null) inst = new Database();
         users.add(usr);
         return inst;
    }

    // Return FullData asis
    FullData data(){
         return fullDatabase;
    }

    // Add new User to holders of current operations
    void registerUser(BaseStore<?> user){
         users.add(user);
    }

    // Write database to file
    void write() throws IOException {
         objMap.writeValue(database.toFile(),fullDatabase);
    }
}
