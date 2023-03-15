

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.util.HashSet;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class StudentCourseRequirements extends Course {
	private static int totalStudentCourseIDs = 0;
	private PartTimeTeacher teacher; 
	private TimetableDate studentCourseDateTime;
	private HashSet<String> requiredSkills;


	// Simple constructor left in to add student course ID
	public StudentCourseRequirements(){
		this.courseID = totaStudentCourseIDs++;
	}


		/*	SETTERS	*/
	// NOTE: Class also has setters for course name and description inherited from Course abstract class
		
	// Sets date time for the student course	
	public void setRequiredSkills(HashSet<String> newRequiredSkills){
		this.requiredSkills = newRequiredSkills;
	} 
		
	// Sets date time for the student course	
	public void setStudentCourseDateTime(TimetableDate newCourseDateTime){
		this.studentCourseDateTime = newCourseDateTime;
	} 

	// Sets teacher assigned to teach the student course	
	public void setTeacher(PartTimeTeacher newTeacher){
		this.teacher = newTeacher;
	} 



		/*	GETTERS	*/
	// NOTE: Class also has getters for course name, description and course ID, inherited from Course abstract class

	// Getter for the date/time scheduled for the student course
	public TimetableDate getTimetabledDate(){
		return studentCourseDateTime;
	}

	// Gets teacher assigned to teach the student course	
	public PartTimeTeacher getTeacher(){
		return teacher;
	} 

	// Returns total list of requirements
	public HashSet<String> getSkillsRequired(){
		return requiredSkills;
	}
	
	

	
}

