package softwareengineering_ae2.CourseClasses;

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
	protected int courseID;
	private String nameOfCourse;
	private String courseDescription;
	private String teacherSet;


		/*    SETTERS    */	
	// Sets the name of the specific course
	public void setCourseName(String inputCourseName){
		this.nameOfCourse = inputCourseName;
	}
	// Sets the description of the specific course
	public void setCourseDescription(String inputCourseDesc){
		this.courseDescription = inputCourseDesc;
	}

		/*    GETTERS    */
	// Return the courseID for the specific course
	public int getCourseID(){
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

	public void setTeacher(String name){
		this.teacherSet = name;
	}

}
