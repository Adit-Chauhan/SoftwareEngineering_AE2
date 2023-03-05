package CourseWork;

private abstract class Course{
	private int courseID;
	private String nameOfCourse;
	private String courseDescription;

	// Simple baseline constructor for all subclasses of Course
	public Course(String inputCourseName, String inputCourseDesc){
		this.nameOfCourse = inputCourseName;
		this.courseDescription = inputCourseDesc;
	}

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

}
