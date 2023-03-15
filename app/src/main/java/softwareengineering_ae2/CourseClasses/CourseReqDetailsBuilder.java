package softwareengineering_ae2.CourseClasses;

import java.util.HashSet;

import java.util.HashSet;

public interface CourseReqDetailsBuilder{
	
	public void addName(String inputName);
	public void addDesc(String inputDesc);
	public void addSkills(HashSet<String> skillSet);
	
	public Course getCourseRelatedObject();

}

