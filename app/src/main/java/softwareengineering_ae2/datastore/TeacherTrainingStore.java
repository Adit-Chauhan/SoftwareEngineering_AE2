package softwareengineering_ae2.datastore;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class TeacherTrainingStore {
    static private DataStore database;
    static TeacherTrainingStore inst;
    public static final int HasSpace = 1;
    public static final int Full = 1 << 1;
    private TeacherTrainingStore() throws IOException {
        database = DataStore.getInstance();
    }
    public static TeacherTrainingStore getInstance() throws IOException {
        if(inst == null) inst = new TeacherTrainingStore();
        return inst;
    }

    public List<CourseWork.TeacherTrainingCourse> getAllTeacherCourses(){
        return database.data().getTeacherCourse();
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
