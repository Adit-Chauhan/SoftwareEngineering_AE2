package softwareengineering_ae2.datastore;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StudentCourseStore {
    static private DataStore database;
    static StudentCourseStore inst;
    public static final int Unassigned = 1;
    public static final int Assigned = 1 << 1;
    private StudentCourseStore() throws IOException {
        database = DataStore.getInstance();
    }
    public static StudentCourseStore getInstance() throws IOException {
        if(inst == null) inst = new StudentCourseStore();
        return inst;
    }

    public List<MockSCR> getAllStudentCourses(){
        return database.data().getStudentCourse();
    }

    public Iterator<MockSCR> getFilteredStudentCourses(int filterSettings){
        Stream<MockSCR> v =  Stream.empty();
        if ((filterSettings & Unassigned) == Unassigned){
            Stream.concat(v,getAllStudentCourses().stream().filter(s -> !s.assigned));
        }
        if((filterSettings & Assigned) == Assigned) Stream.concat(v,getAllStudentCourses().stream().filter(s->s.assigned));
        v = v.distinct(); // Should not be possible in this case but for security
        return v.iterator();
    }
}
