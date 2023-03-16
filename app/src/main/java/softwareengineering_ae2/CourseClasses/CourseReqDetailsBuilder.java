package softwareengineering_ae2.CourseClasses;

import java.util.HashSet;

/**
*	CourseReqDetailsBuilder interface: Defines basic interface for Builder pattern for creating Course-related classes.
*
* @see: StudentCourseRequirementsBuilder.java
* @see: TeacherTrainingCourseDetailsBuilder.java
*
*/
public interface CourseReqDetailsBuilder{
	
	public void addName(String inputName);
	public void addDesc(String inputDesc);
	public void addSkills(HashSet<String> skillSet);
	
	public Course getCourseRelatedObject();

}

