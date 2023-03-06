package softwareengineering_ae2.CourseClasses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.TreeSet;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class StudentCourseRequirements extends Course {
	private static int totalStudentCourseIDs = 0;
	private String teacher; // TODO: Answer Q: Make a reference to a Teacher object instead? i.e how much information is required? // private PartTimeTeacher teacher;
							// TODO: ADIT:: I think we can it may prevent useless data duplication (that said i am not aware of the rules of when java will copy data)
	private TimetableDate studentCourseDateTime;
	private TreeSet<String> requiredSkills; // Q: ADIT, Just curious as to why did you use TreeSet is the order of skills important?

	//TODO: Answer Q, maybe add more constructors
	// Q: >1 constructor required (with accompanying getters/setters?) if we don't have all these details??) Or do we not want anyone to modify the specific course once it is created?
	public StudentCourseRequirements(String inputCourseName, String inputCourseDesc, TimetableDate inputTime, TreeSet<String> inputRequiredSkills){
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
