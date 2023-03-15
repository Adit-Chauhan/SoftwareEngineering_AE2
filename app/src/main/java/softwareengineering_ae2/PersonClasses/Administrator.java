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
   
    public void readStudentCourseInfo(){
        

    }
    




    
    public void readTeacherTrainingInfo(){

    }



    
    public void readPartTimeTeacherInfo(){

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
