package softwareengineering_ae2.datastore;

import softwareengineering_ae2.CourseClasses.TeacherTrainingCourse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TeacherTrainingStore extends BaseStore<TeacherTrainingCourse> {
    static TeacherTrainingStore inst;
    public static final int HasSpace = 1;
    public static final int Full = 1 << 1;
    private TeacherTrainingStore() throws IOException {
        super();
    }

    // Only add new data if new entry
    @Override
    public void add(TeacherTrainingCourse val) {
        if(localData == null)localData = new ArrayList<>();
        Optional<TeacherTrainingCourse> maybeCourse = localData.stream().filter(c -> c.getCourseID() == val.getCourseID()).findFirst();
        maybeCourse.ifPresent(teacherTrainingCourse -> localData.remove(teacherTrainingCourse)); // Remove if entry exists
        localData.add(val); // add new entry
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

    // These are not being used in the program but where made in consideration that if a Database is used it is more
    // efficient to pass simple checks such as these to Database Queries
    public List<TeacherTrainingCourse> getFilteredTeachers(int filterSettings){
        Stream<TeacherTrainingCourse> v =  Stream.empty();
        if ((filterSettings & HasSpace) == HasSpace) Stream.concat(v, getAllTeacherCourses().stream().filter(s -> s.getSpacesLeft()>0));

        if((filterSettings & Full) == Full) Stream.concat(v,getAllTeacherCourses().stream().filter(s->s.getSpacesLeft() == 0));
        return v.toList();
    }
}
