package softwareengineering_ae2.datastore;

import softwareengineering_ae2.CourseClasses.TeacherTrainingCourse;
import softwareengineering_ae2.PersonClasses.Teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class TeacherStore extends BaseStore<Teacher> {
    static TeacherStore inst;
    public static final int Unassigned = 1;
    public static final int Assigned = 1 << 1;
    public static final int Trained = 1 << 2;
    public static final int Untrained = 1 << 3;
    private TeacherStore() throws IOException {
        super();
    }

    @Override
    public void add(Teacher val) {
        if(localData == null)localData = new ArrayList<>();
        Optional<Teacher> maybeTeacher = localData.stream().filter(c -> c.getId() == val.getId()).findFirst();
        maybeTeacher.ifPresent(teacher -> localData.remove(teacher));
        localData.add(val);
    }

    public static TeacherStore getInstance() throws IOException {
        if(inst == null) inst = new TeacherStore();
        return inst;
    }

    public Iterator<Teacher> getFilteredTeachersOr(int filterSettings){
        Stream<Teacher> v =  Stream.empty();
        if ((filterSettings & Unassigned) == Unassigned) Stream.concat(v,getData().stream().filter(s -> !s.isAssigned()));
        if((filterSettings & Assigned) == Assigned)      Stream.concat(v,getData().stream().filter(Teacher::isAssigned));
        if((filterSettings & Trained) == Trained)        Stream.concat(v,getData().stream().filter(Teacher::getTrainingCompletedStatus));
        if((filterSettings & Untrained) == Untrained)    Stream.concat(v,getData().stream().filter(s-> !s.getTrainingCompletedStatus()));

        v = v.distinct(); // Remove common
        return v.iterator();
    }

    public Iterator<Teacher> getFilteredTeachersAnd(int filterSettings){
        Stream<Teacher> v = getData().stream();
        if ((filterSettings & Unassigned) == Unassigned) v=v.filter(s -> !s.isAssigned());

        if((filterSettings & Assigned) == Assigned)      v=v.filter(Teacher::isAssigned);

        if((filterSettings & Trained) == Trained)        v=v.filter(Teacher::getTrainingCompletedStatus);

        if((filterSettings & Untrained) == Untrained)    v=v.filter(s-> !s.getTrainingCompletedStatus());

        return v.iterator();
    }

    @Override
    public List<Teacher> getData() {
        if (localData == null)localData = data().getTeachers();

        return localData;
    }

    @Override
    public void update() {
        data().setTeachers(localData);
    }
}
