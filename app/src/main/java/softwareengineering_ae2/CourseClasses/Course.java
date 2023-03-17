package softwareengineering_ae2.CourseClasses;

import softwareengineering_ae2.PersonClasses.Teacher;
import softwareengineering_ae2.TimetableDate.TimetableDate;

import java.util.UUID;
import java.util.HashSet;

/**
*	Course Abstract class: Defines basic attributes and methods required for course-related classes to inherit.
*	Methods from here are also used in the CourseReqDetailsBuilder.java Builder Interface.
*
* @see: CourseReqDetailsBuilder.java
* @see: StudentCourseRequirements.java
* @see: TeacherTrainingCourse.java
*
*/
public abstract class Course{
	protected UUID courseID;
	private String nameOfCourse;
	private String courseDescription;
	private HashSet<String> skillSet;

	private TimetableDate timetabledDate;
	public Course(){
		courseID = UUID.randomUUID();
	}



	public abstract void setTeacher(Teacher newTeacher);

	/*    SETTERS    */
	// Sets the name of the specific course
	public void setCourseName(String inputCourseName){
		this.nameOfCourse = inputCourseName;
	}
	// Sets the description of the specific course
	public void setCourseDescription(String inputCourseDesc){
		this.courseDescription = inputCourseDesc;
	}
	
	// Sets skillset for the course	
	public void setSkillSet(HashSet<String> newSkillSet){
		this.skillSet = newSkillSet;
	} 

		/*    GETTERS    */
	// Return the courseID for the specific course

	public UUID getCourseID() {
		return courseID;
	}

	// Return the name of the specific course
	public String getCourseName(){
		return nameOfCourse;
	}
	// Return the description of the specific course
	public String getCourseDescription(){
		return courseDescription;
	}
	
	// Returns the skillset for the course	
	public HashSet<String> getSkillSet(){
		return this.skillSet;
	}

	public void setCourseID(UUID courseID) {
		this.courseID = courseID;
	}

	public String getNameOfCourse() {
		return nameOfCourse;
	}

	public void setNameOfCourse(String nameOfCourse) {
		this.nameOfCourse = nameOfCourse;
	}

// Sets teacher assigned to teach the student course
}
