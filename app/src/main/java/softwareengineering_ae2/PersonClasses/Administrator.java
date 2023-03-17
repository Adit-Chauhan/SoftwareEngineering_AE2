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
    TeacherStore teachers;
    TeacherTrainingStore teachCourse;
    StudentCourseStore studentCourses;

    public Administrator() throws IOException {
        teachers = TeacherStore.getInstance();
        teachCourse = TeacherTrainingStore.getInstance();
        studentCourses = StudentCourseStore.getInstance();
    }

    public void matchTeachersToStudentCourse(Course course, ArrayList<Teacher> teacher) {
        for (Teacher t : teacher) {
            int skillcount = 0;
            if (t.getTrainingCompletedStatus()) {
                //::ADIT:: Logic seems correct but it should be better if we moved the taught skillset to Course class and
                // ran a for loop on that instead we don't even need to run this on Parent class as function is only
                // Called for.
                //List<String> des = new ArrayList<String>(Arrays.asList(course.getCourseDescription().split(" "))); //::LYNETTE:: why using course description when the course already has a hashset of required skills? "HashSet<String> requiredSkills" -> getSkillsRequired() gives you this
                HashSet<String> des = course.getSkillSet();
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
        //Iterator<Teacher> freeTeachers = teachers.getFilteredTeachersOr(TeacherStore.Unassigned); // Get free Teachers
        var freeTeachers = teachers.getData();
        ArrayList<Teacher> validTeachers = new ArrayList<>();
        for (var teach : freeTeachers) {
            var countSkill = teach.getTeacherSkillSet().stream().filter(skill -> course.getSkillSet().contains(skill)).count();
            if (countSkill > 4) {
                validTeachers.add(teach);
            }
        }
        return validTeachers;
    }


    public void run() {
        System.out.println("Select Student Course to Assign Teacher: ");
        Teacher t = new Teacher("j",2,"h");
        var a = new ArrayList<String>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        a.add("e");
        a.add("f");
        t.setTeacherSkillSet(a);
        t.setTeacherName("mr Gigo");
        t.hasCompletedTraining = true;
        teachers.add(t);
        int idx = 0;
        //var unassignedCourses = studentCourses.getFilteredStudentCourses(StudentCourseStore.Unassigned);
        List<StudentCourseRequirements> uassignedCourses = studentCourses.getData();
        var uCourse = new ArrayList<StudentCourseRequirements>();
        for(var course: uassignedCourses){
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
