package softwareengineering_ae2.datastore;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


public class TeacherStore extends BaseStore<MockTeacher> {
    static TeacherStore inst;
    public static final int Unassigned = 1;
    public static final int Assigned = 1 << 1;
    public static final int Trained = 1 << 2;
    public static final int Untrained = 1 << 3;
    private TeacherStore() throws IOException {
        super();
        registerUser(this);
    }
    public static TeacherStore getInstance() throws IOException {
        if(inst == null) inst = new TeacherStore();
        return inst;
    }

    public Iterator<MockTeacher> getFilteredTeachersOr(int filterSettings){
        Stream<MockTeacher> v =  Stream.empty();
        if ((filterSettings & Unassigned) == Unassigned) Stream.concat(v,getData().stream().filter(s -> !s.assigned));
        if((filterSettings & Assigned) == Assigned)      Stream.concat(v,getData().stream().filter(s->s.assigned));
        if((filterSettings & Trained) == Trained)        Stream.concat(v,getData().stream().filter(s-> s.trained));
        if((filterSettings & Untrained) == Untrained)    Stream.concat(v,getData().stream().filter(s-> !s.trained));

        v = v.distinct(); // Remove common
        return v.iterator();
    }

    public Iterator<MockTeacher> getFilteredTeachersAnd(int filterSettings){
        Stream<MockTeacher> v = getData().stream();
        if ((filterSettings & Unassigned) == Unassigned) v=v.filter(s -> !s.assigned);

        if((filterSettings & Assigned) == Assigned)      v=v.filter(s->s.assigned);

        if((filterSettings & Trained) == Trained)        v=v.filter(s-> s.trained);

        if((filterSettings & Untrained) == Untrained)    v=v.filter(s-> !s.trained);

        return v.iterator();
    }

    @Override
    public List<MockTeacher> getData() {
        if (localData == null)localData = data().getTeachers();

        return localData;
    }

    @Override
    public void update() {
        data().setTeachers(localData);
    }
}
