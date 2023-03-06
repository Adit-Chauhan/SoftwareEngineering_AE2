package softwareengineering_ae2.datastore;

import CourseWork.TeacherTrainingCourse;
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
    List<CourseWork.TeacherTrainingCourse> teacherCourse;
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


class DataStore {
    static private Path database;
    static private FullData fullDatabase;
    private static DataStore inst;
     private DataStore() throws IOException {
        if(database == null) database = Paths.get("data/data.json");

        if(fullDatabase == null) fullDatabase = new ObjectMapper().readValue(database.toFile(), FullData.class);
    }

    static DataStore getInstance()throws IOException {
         if(inst == null) inst = new DataStore();
         return inst;
    }

    FullData data(){
         return fullDatabase;
    }
}
