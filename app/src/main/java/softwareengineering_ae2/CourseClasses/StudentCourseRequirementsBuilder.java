package softwareengineering_ae2.CourseClasses;


import softwareengineering_ae2.TimetableDate.TimetableDate;

import java.util.HashSet;


/**
*	StudentCourseRequirementsBuilder class: Concrete builder for creating StudentCourseRequirements objects.
*
* @see: CourseReqDetailsBuilder.java
* @see: StudentCourseRequirements.java
*
*/
public class StudentCourseRequirementsBuilder implements CourseReqDetailsBuilder {
	StudentCourseRequirements studentCourse; 

	// Constructor for this builder. Creates a new StudentCourseRequirements object & assigns it an ID
	public StudentCourseRequirementsBuilder(){
		studentCourse = new StudentCourseRequirements();
	}

	
	/*    Methods overridden from CourseReqDetailsBuilder    */
	@Override
	// AddName to the StudentCourseRequirements object
	public void addName(String inputName){
		this.studentCourse.setCourseName(inputName);
	};

	@Override
	// AddDescription to the StudentCourseRequirements object
	public void addDesc(String inputDesc){
		this.studentCourse.setCourseDescription(inputDesc);
	};

	@Override
	// AddSkillset to the StudentCourseRequirements object
	public void addSkills(HashSet<String> inputSkillSet){
		this.studentCourse.setSkillSet(inputSkillSet);
	};

	/*    Method specific to StudentCourseRequirements object setup    */
	// Add date time for the student course	
	public void addStudentCourseDateTime(TimetableDate inputCourseDateTime){
		this.studentCourse.setStudentCourseDateTime(inputCourseDateTime);
	} 

	
	
	/*    StudentCourseRequirements object completion    */
	// Returns the completed StudentCourseRequirements object
	public StudentCourseRequirements getCourseRelatedObject(){
		return this.studentCourse;
	};


}
