package softwareengineering_ae2.PersonClasses;

import softwareengineering_ae2.CourseClasses.Course;
import softwareengineering_ae2.CourseClasses.StudentCourseRequirements;
import softwareengineering_ae2.CourseClasses.TeacherTrainingCourse;
import softwareengineering_ae2.TimetableDate.TimetableDate;
import softwareengineering_ae2.datastore.StudentCourseStore;
import softwareengineering_ae2.datastore.TeacherStore;
import softwareengineering_ae2.datastore.TeacherTrainingStore;

import java.io.IOException;
import java.util.*;

public class Administrator {
//    int AdminID;
//    ArrayList<Teacher> allPartTimeTeachingStaff;
//    ArrayList<StudentCourseRequirements> allStudentCourses;
//    ArrayList<TeacherTrainingCourse> allTeacherTrainingCourses;
    TeacherStore teachers;
    TeacherTrainingStore teachCourse;
    StudentCourseStore studentCourses;

    public Administrator() throws IOException {
        teachers = TeacherStore.getInstance();
        teachCourse = TeacherTrainingStore.getInstance();
        studentCourses = StudentCourseStore.getInstance();
    }

//    public void readStudentCourseInfo() {
//        //::ADIT:: What is this function doing?
//        // It just reads the data and stores it in references on stack
//        // all this information cannot be accessed ...
//        for (StudentCourseRequirements course : StudentCourseStore.getData()) {
//            int coursID = course.getCourseID();
//            String courseName = course.getCourseName();
//            String courseDescription = course.getCourseDescription();
//            TimetableDate courseDate = course.getTimetabledDate();
//            Teacher coursePTTeacher = course.getTeacher();
//        }
//    }
//
//
//    public void readTeacherTrainingInfo() {
//        //::ADIT:: Same problem as previous the references just get cleared when the scope ends
//        for (TeacherTrainingCourse ttc : TeacherTrainingStore.getData()) {
//            int ttcID = ttc.getID(); //::ADIT:: I made a getter for ID but ID is a static variable It will be same for all
//            // responses
//            int tthcClassSize = ttc.getTeacherTrainingClassSize();
//            ArrayList<TimetableDate> ttcTimes = ttc.getTrainingTimes();
//            HashSet<String> ttcSkills = ttc.getTaughtSkillSet();
//        }
//    }
//
//    public void readPartTimeTeacherInfo() {
//        //::ADIT:: Same problem as previous the references just get cleared when the scope ends
//        for (Teacher t : TeacherStore.getData()) {
//            String tName = t.getName();
//            boolean tTrainingsCompleted = t.getTrainingCompletedStatus();
//            ArrayList<TimetableDate> tAvailability = t.getTeacherAvailability();
//            ArrayList<String> tSkillset = t.getTeacherSkillSet();
//
//        }
//    }
//
//
    public void matchTeachersToStudentCourse(Course course, ArrayList<Teacher> teacher) {
        for (Teacher t : teacher) {
            int skillcount = 0;
            if (t.getTrainingCompletedStatus()) {
                //::ADIT:: Logic seems correct but it should be better if we moved the taught skillset to Course class and
                // ran a for loop on that instead we don't even need to run this on Parent class as function is only
                // Called for.
                List<String> des = new ArrayList<String>(Arrays.asList(course.getCourseDescription().split(" ")));
                for (String skill : t.getTeacherSkillSet()) {
                    for (String s : des) {
                        if (skill.equals(s)) {
                            skillcount++;
                        }
                    }

                }
            }
            if (skillcount > 4) {
                course.setTeacher(t);
            }

        }

    }

    public void matchTeachersToTeacherTraining(Teacher teacher, ArrayList<TeacherTrainingCourse> trainingcourses) {
        for (TimetableDate time : teacher.getTeacherAvailability()) {
            for (TeacherTrainingCourse ttc : trainingcourses) {
                for (TimetableDate trianingtime : ttc.getTrainingTimes()) {
                    if (time.equals(trianingtime)) {
                        ttc.addAttendee(teacher);
                    }
                }
            }
        }

    }

    public ArrayList<Teacher> matchTeachersToStudentCourse(StudentCourseRequirements course) {
        Iterator<Teacher> freeTeachers = teachers.getFilteredTeachersOr(TeacherStore.Unassigned); // Get free Teachers
        ArrayList<Teacher> validTeachers = new ArrayList<>();
        while (freeTeachers.hasNext()) {
            var teach = freeTeachers.next();
            var countSkill = teach.getTeacherSkillSet().stream().filter(skill -> course.getSkillsRequired().contains(skill)).count();
            if (countSkill > 4) {
                validTeachers.add(teach);
            }
        }
        return validTeachers;
    }


    public void run() {
        System.out.println("Select Student Course to Assign Teacher: ");
        int idx = 0;
        var unassignedCourses = studentCourses.getFilteredStudentCourses(StudentCourseStore.Unassigned);
        var uCourse = new ArrayList<StudentCourseRequirements>();
        while(unassignedCourses.hasNext()){
            var course = unassignedCourses.next();
            uCourse.add(course);
            System.out.println("["+ idx +"] " + course.getCourseName());
            idx++;
        }
        Scanner r = new Scanner(System.in);
        var selectedCourse = r.nextInt();

        var validTeachers = matchTeachersToStudentCourse(uCourse.get(selectedCourse));
        for(int i = 0; i< validTeachers.size();i++){
            System.out.println("["+i+"] " + validTeachers.get(i).getTeacherName());
        }

        var seclectedTeacher = r.nextInt();
        var te = validTeachers.get(seclectedTeacher);
        te.setAssigned(true);
        var sc = uCourse.get(selectedCourse);
        sc.setTeacher(te);
        teachers.add(te);
        studentCourses.add(sc);
    }
}
