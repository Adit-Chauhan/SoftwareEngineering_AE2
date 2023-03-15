package softwareengineering_ae2.datastore;

import softwareengineering_ae2.CourseClasses.TeacherTrainingCourse;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StudentCourseStore extends BaseStore<MockSCR> {
    static StudentCourseStore inst;
    public static final int Unassigned = 1;
    public static final int Assigned = 1 << 1;
    private StudentCourseStore() throws IOException {
        super();
    }

    @Override
    protected void add(MockSCR val) {
        Optional<MockSCR> maybeCourse = localData.stream().filter(c -> c.getCourseID() == val.getCourseID()).findFirst();
        maybeCourse.ifPresent(teacherTrainingCourse -> localData.remove(teacherTrainingCourse));
        localData.add(val);
    }

    @Override
    public List<MockSCR> getData() {
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
    public Iterator<MockSCR> getFilteredStudentCourses(int filterSettings){
        Stream<MockSCR> v =  Stream.empty();
        if ((filterSettings & Unassigned) == Unassigned) Stream.concat(v, getData().stream().filter(s -> !s.assigned));

        if((filterSettings & Assigned) == Assigned) Stream.concat(v,getData().stream().filter(s->s.assigned));

        v = v.distinct(); // Should not be possible in this case but for security
        return v.iterator();
    }
}
