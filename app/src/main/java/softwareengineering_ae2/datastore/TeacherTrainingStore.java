package softwareengineering_ae2.datastore;

import softwareengineering_ae2.CourseClasses.TeacherTrainingCourse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class TeacherTrainingStore extends BaseStore<TeacherTrainingCourse> {
    static TeacherTrainingStore inst;
    public static final int HasSpace = 1;
    public static final int Full = 1 << 1;
    private TeacherTrainingStore() throws IOException {
        super();
    }

    @Override
    public void add(TeacherTrainingCourse val) {
        Optional<TeacherTrainingCourse> maybeCourse = localData.stream().filter(c -> c.getCourseID() == val.getCourseID()).findFirst();
        maybeCourse.ifPresent(teacherTrainingCourse -> localData.remove(teacherTrainingCourse));
        localData.add(val);
    }

    public static TeacherTrainingStore getInstance() throws IOException {
        if(inst == null) inst = new TeacherTrainingStore();
        return inst;
    }

    public List<TeacherTrainingCourse> getAllTeacherCourses(){
        return data().getTeacherCourse();
    }

    @Override
    public List<TeacherTrainingCourse> getData() {
        if (localData == null) localData = data().getTeacherCourse();
        return localData;
    }

    @Override
    public void update() {
        data().setTeacherCourse(localData);
    }
/*
 * TODO: Include if implemented in Courses
 *
    public Iterator<CourseWork.TeacherTrainingCourse> getFilteredTeachers(int filterSettings){
        Stream<CourseWork.TeacherTrainingCourse> v =  Stream.empty();
        if ((filterSettings & HasSpace) == HasSpace) Stream.concat(v, getAllTeacherCourses().stream().filter(s -> s.getSpacesLeft()>0));

        if((filterSettings & Full) == Full) Stream.concat(v,getAllTeacherCourses().stream().filter(s->s.getSpacesLeft() == 0));
        v = v.distinct(); // Should not be possible in this case but for security
        return v.iterator();
    }

 */
}
