package softwareengineering_ae2.CourseClasses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import softwareengineering_ae2.PersonClasses.Teacher;
import softwareengineering_ae2.TimetableDate.TimetableDate;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)


/**
*	StudentCourseRequirements class: Defines further attributes and methods specific to StudentCourseRequirements. Extends Course Abstract class.
*	Methods from here are also used in the StudentCourseRequirementsBuilder.java Builder Class, as well as Administrator.java.
*
* @see: StudentCourseRequirementsBuilder.java
* @see: Administrator.java
*
*/
public class StudentCourseRequirements extends Course {
	private Teacher teacher;
	private TimetableDate studentCourseDateTime;


	// Simple constructor left in to add student course ID
	public StudentCourseRequirements(){
		super();
	}


		/*	SETTERS	*/
	// NOTE: Class also has setters for course name, description and skillset inherited from Course abstract class
		
	// Sets date time for the student course	
	public void setStudentCourseDateTime(TimetableDate newCourseDateTime){
		this.studentCourseDateTime = newCourseDateTime;
	} 

	// Sets teacher assigned to teach the student course	
	public void setTeacher(Teacher newTeacher){
		this.teacher = newTeacher;
	} 



		/*	GETTERS	*/
	// NOTE: Class also has getters for course name, description, ID, and skillset inherited from Course abstract class

	// Getter for the date/time scheduled for the student course
	public TimetableDate getTimetabledDate(){
		return studentCourseDateTime;
	}

	// Gets teacher assigned to teach the student course	
	public Teacher getTeacher(){
		return teacher;
	} 

}

