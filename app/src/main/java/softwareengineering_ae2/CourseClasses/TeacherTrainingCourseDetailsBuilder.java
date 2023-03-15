package softwareengineering_ae2.CourseClasses;

import java.util.HashSet;

public class TeacherTrainingCourseDetailsBuilder implements CourseReqDetailsBuilder{
	TeacherTrainingCourse teachingCourse;
	
	// Constructor for this builder. Creates a new TeacherTrainingCourse object & assigns it an ID
	public TeacherTrainingCourseDetailsBuilder(){
		teachingCourse = new TeacherTrainingCourse();
	}

	/*    Methods overridden from CourseReqDetailsBuilder    */
	@Override
	// AddName to the TeacherTrainingCourse object
	public void addName(String inputName){
		this.teachingCourse.setCourseName(inputName);
	};

	@Override
	// AddDescription to the TeacherTrainingCourse object
	public void addDesc(String inputDesc){
		this.teachingCourse.setCourseDescription(inputDesc);
	};

	
	// Add taught skillset to the TeacherTrainingCourse object
	@Override
	public void addSkills(HashSet<String> skillSet){
		this.teachingCourse.setTaughtSkillSet(skillSet);
	};


	/*    Methods specific to StudentCourseRequirements object setup    */
	// Adds list of times scheduled for the TeacherTrainingCourse object
	public void addTrainingTimes(ArrayList<TimetableDate> inputTrainingTimes){
		this.teachingCourse.setTrainingTimes(inputTrainingTimes);
	}
	
	// Adds maximum course capacity for the TeacherTrainingCourse object
	public void addTeacherTrainingClassSize(int inputMaxCourseCapacity){
	public void setTeacherTrainingClassSize(int inputMaxCourseCapacity){
		this.teachingCourse.setTeacherTrainingClassSize(inputMaxCourseCapacity);
	}

	
		/*    TeacherTrainingCourse object completion    */
	// Returns the completed TeacherTrainingCourse object
	public TeacherTrainingCourse getCourseRelatedObject(){
		return this.teachingCourse;
	};


}
