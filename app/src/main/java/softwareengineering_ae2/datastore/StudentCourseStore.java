package softwareengineering_ae2.datastore;


import softwareengineering_ae2.CourseClasses.StudentCourseRequirements;

import java.io.IOException;
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

    @Override
    public void add(StudentCourseRequirements val) {
        Optional<StudentCourseRequirements> maybeCourse = localData.stream().filter(c -> c.getCourseID() == val.getCourseID()).findFirst();
        maybeCourse.ifPresent(teacherTrainingCourse -> localData.remove(teacherTrainingCourse));
        localData.add(val);
    }

    @Override
    public List<StudentCourseRequirements> getData() {
        if(localData == null) localData = data().getStudentCourse();
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
    public Iterator<StudentCourseRequirements> getFilteredStudentCourses(int filterSettings){
        Stream<StudentCourseRequirements> v =  Stream.empty();
        if ((filterSettings & Unassigned) == Unassigned) Stream.concat(v, getData().stream().filter(s -> !(s.getTeacher()== null)));

        
        if((filterSettings & Assigned) == Assigned) Stream.concat(v,getData().stream().filter(s-> s.getTeacher() != null));

        v = v.distinct(); // Should not be possible in this case but for security
        return v.iterator();
    }
}
