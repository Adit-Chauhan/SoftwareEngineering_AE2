package main.java.softwareengineering_ae2.PersonClasses;
import main.java.softwareengineering_ae2.CourseClasses.Course;
import main.java.softwareengineering_ae2.TimetableDate.TimetableDate;
import softwareengineering_ae2.PersonClasses.Teacher;
import java.util.ArrayList;
public class Administrator {
    int AdminID;
    ArrayList<PartTimeTeacher> allPartTimeTeachingStaff;
    ArrayList<StudentCourse> allStudentCourses;
    ArrayList<TeacherTrainingCourses> allTeacherTrainingCourses;
   
<<<<<<< HEAD
    public void readStudentCourseInfo(){
        

=======
       public void readStudentCourseInfo(){
    	for (Course course : StudentCourseStore.getData()) {
    		  String courseID = course.getCourseID();
              int courseName = course.getCourseName();
              int courseDescription = course.getCourseDescription();
              int courseDate = StudentCourseRequirement.getTimetabledDate();
              int coursePTTeacher = StudentCourseRequirement.getTeacher()
    	}
>>>>>>> ccdda58be2effe411bfc00f2b471fac7bced2024
    }

    public void readTeacherTrainingInfo(){
        for (TeacherTrainingCourse ttc : TeacherTrainingStore.getData()) {
            int ttcID = ttc.getID();
            int tthcClassSize = ttc.getTainingClassSize();
            ArrayList<TimetableDate> ttcTimes = ttc.getTrainingTimes();
            HashSet<String> ttcSkills = ttc=getTaughtSkillSet();       
        }
    }

    public void readPartTimeTeacherInfo(){
      for (Teacher t : TeacherStore.getData()) {
            String tName = t.getName();
            boolean tTrainingsCompleted = t.getTrainingCompletedStatus(); 
            ArrayList<TimetableDate> tAvailability = t.getTeacherAvailability();
            ArrayList<String> tSkillset = t.getSkillset();
            
        }
    }


    
    public void matchTeachersToStudentCourse(Course course, ArrayList<Teacher> teacher){
        for(Teacher t : teacher){
            int skillcount =0;
            if(t.getTrainingCompletedStatus()){
                List<String> des = new ArrayList<String>(Arrays.asList(course.getCourseDescription.split(" ")));
                for(String skill : t.getTeacherSkillSet()){
                    for(String s : des){
                        if(skill.equals(s)){
                            skillcount++;
                        }
                    }

                } 
            }
            if(skillcount > 4){
                course.setTeacher(t.getName())
            }

        }

    }




    public void matchTeachersToTeacherTraining(Teacher teacher, ArrayList<TeacherTrainingCourse> ttc){

    }
   
}
