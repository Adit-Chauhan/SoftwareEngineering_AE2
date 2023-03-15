package main.java.softwareengineering_ae2.PersonClasses;
import softwareengineering_ae2;
public class Administrator {
    int AdminID;
    ArrayList<PartTimeTeacher> allPartTimeTeachingStaff;
    ArrayList<StudentCourse> allStudentCourses;
    ArrayList<TeacherTrainingCourses> allTeacherTrainingCourses;
   
       public void readStudentCourseInfo(){
    	for (Course course : StudentCourseStore.getData()) {
    		  String courseID = course.getCourseID();
              int courseName = course.getCourseName();
              int courseDescription = course.getCourseDescription();
              int courseDate = StudentCourseRequirement.getTimetabledDate();
              int coursePTTeacher = StudentCourseRequirement.getTeacher()
    	}
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

    }




    public void matchTeachersToTeacherTraining(Teacher teacher, ArrayList<TeacherTrainingCourse> ttc){

    }
   
}
