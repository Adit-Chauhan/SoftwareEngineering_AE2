package CourseClasses;

import java.util.TreeSet;

public class StudentCourseRequirements extends Course {
	private static int totalStudentCourseIDs = 0;
	private String teacher; // TODO: Answer Q: Make a reference to a Teacher object instead? i.e how much information is required? // private PartTimeTeacher teacher;
	private TimetableDate studentCourseDateTime;
	private TreeSet<String> requiredSkills;

	//TODO: Answer Q, maybe add more constructors
	// Q: >1 constructor required (with accompanying getters/setters?) if we don't have all these details??) Or do we not want anyone to modify the specific course once it is created?
	public StudentCourse(String inputCourseName, String inputCourseDesc, TimetableDate inputTime, TreeSet<String> inputRequiredSkills){
		super(inputCourseName, inputCourseDesc);
		
		this.courseID = totalStudentCourseIDs++;
		this.studentCourseDateTime = inputTime;
		this.requiredSkills = inputRequiredSkills;
	}


	// Getter for the date/time scheduled for the student course
	public TimetableDate getTimetabledDate(){
		return studentCourseDateTime;
	}

	// Getters and setters for teacher assigned to teach the student course	
	public String getTeacher(){
		return teacher;
	} // TODO: Update implementation if changed to Teacher object
	
	public void setTeacher(String newTeacher){
		this.teacher = newTeacher;
	} // TODO: Update implementation if changed to Teacher object


	
	
	// Returns total list of requirements
	public TreeSet<String> getSkillsRequired(){
		return requiredSkills;
	}



}
