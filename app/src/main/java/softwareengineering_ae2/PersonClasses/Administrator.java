package softwareengineering_ae2.PersonClasses;

import softwareengineering_ae2.CourseClasses.Course;
import softwareengineering_ae2.CourseClasses.StudentCourseRequirements;
import softwareengineering_ae2.CourseClasses.TeacherTrainingCourse;
import softwareengineering_ae2.TimetableDate.TimetableDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Administrator {
    int AdminID;
    ArrayList<Teacher> allPartTimeTeachingStaff;
    ArrayList<StudentCourseRequirements> allStudentCourses;
    ArrayList<TeacherTrainingCourse> allTeacherTrainingCourses;
   
       public void readStudentCourseInfo(){
    	for (Course course : StudentCourseStore.getData()) {
    		  String coursID = course.getCourseID();
              int courseName = course.getCourseName();
              int courseDescription = course.getCourseDescription();
              int courseDate = StudentCourseRequirement.getTimetabledDate();
              int coursePTTeacher = StudentCourseRequirement.getTeacher()
    	}
    }


    public void readTeacherTrainingInfo(){
        //::ADIT:: What is this function doing?
        // It just reads the data and stores it in references on stack
        // all this information cannot be accessed ...
        for (TeacherTrainingCourse ttc : TeacherTrainingStore.getData()) {
            int ttcID = ttc.getID(); //::ADIT:: I made a getter for ID but ID is a static variable It will be same for all
                                    // responses
            int tthcClassSize = ttc.getTeacherTrainingClassSize();
            ArrayList<TimetableDate> ttcTimes = ttc.getTrainingTimes();
            HashSet<String> ttcSkills = ttc.getTaughtSkillSet();
        }
    }

    public void readPartTimeTeacherInfo(){
        //::ADIT:: Same problem as previous the references just get cleared when the scope ends
      for (Teacher t : TeacherStore.getData()) {
            String tName = t.getName();
            boolean tTrainingsCompleted = t.getTrainingCompletedStatus(); 
            ArrayList<TimetableDate> tAvailability = t.getTeacherAvailability();
            ArrayList<String> tSkillset = t.getTeacherSkillSet();
            
        }
    }


    
    public void matchTeachersToStudentCourse(Course course, ArrayList<Teacher> teacher){
        for(Teacher t : teacher){
            int skillcount =0;
            if(t.getTrainingCompletedStatus()){
                //::ADIT:: Logic seems correct but it should be better if we moved the taught skillset to Course class and
                // ran a for loop on that instead we don't even need to run this on Parent class as function is only
                // Called for.
                List<String> des = new ArrayList<String>(Arrays.asList(course.getCourseDescription().split(" ")));
                for(String skill : t.getTeacherSkillSet()){
                    for(String s : des){
                        if(skill.equals(s)){
                            skillcount++;
                        }
                    }

                } 
            }
            if(skillcount > 4){
                course.setTeacher(t.getName());
            }

        }

    }
    public void matchTeachersToTeacherTraining(Teacher teacher, ArrayList<TeacherTrainingCourse> trainingcourses){
        for(TimetableDate time : teacher.getTeacherAvailability()){
            for(TeacherTrainingCourse ttc : trainingcourses){
                for(TimetableDate trianingtime : ttc.getTrainingTimes()){
                    if(time.equals(trianingtime)){
                        ttc.setTeacher(teacher.getName());
                    }
                }
            }
        }

    }
   
}
