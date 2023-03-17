package softwareengineering_ae2.datastore;


import softwareengineering_ae2.CourseClasses.StudentCourseRequirements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StudentCourseStore extends BaseStore<StudentCourseRequirements> {

    static StudentCourseStore inst;
    public static final int Unassigned = 1;
    public static final int Assigned = 1 << 1;
    private StudentCourseStore() throws IOException {
        super();
    }
    // Only add new data if new entry
    @Override
    public void add(StudentCourseRequirements val) {
        if(localData == null) localData = new ArrayList<>();
        Optional<StudentCourseRequirements> maybeCourse = localData.stream().filter(c -> c.getCourseID() == val.getCourseID()).findFirst();
        maybeCourse.ifPresent(teacherTrainingCourse -> localData.remove(teacherTrainingCourse)); // If it finds an older entry then delete it
        localData.add(val); // add entry to list
    }

    // Only get data
    @Override
    public List<StudentCourseRequirements> getData() {
        if(localData == null) localData = data().getStudentCourse();
        if(localData == null) localData = new ArrayList<>();
        return localData;
    }
    @Override
    public void update() {
        data().setStudentCourse(localData);
    }

    public static StudentCourseStore getInstance() throws IOException {
        if(inst == null) inst = new StudentCourseStore();
        return inst;
    }
    // These are not being used in the program but where made in consideration that if a Database is used it is more
    // efficient to pass simple checks such as these to Database Queries
    public List<StudentCourseRequirements> getFilteredStudentCourses(int filterSettings){
        Stream<StudentCourseRequirements> v =  Stream.empty();
        if ((filterSettings & Unassigned) == Unassigned)
            Stream.concat(v, getData().stream().filter(s -> !(s.getTeacher()== null)));

        
        if((filterSettings & Assigned) == Assigned)
            Stream.concat(v,getData().stream().filter(s-> s.getTeacher() != null));

        return v.toList();
    }
}
