package CourseClasses;

import java.util.TreeSet;

public class TeacherTrainingCourse extends Course {
	private static int totalTeacherTrainingCourseIDs = 0;
	private final int maxCourseCapacity;

	/*// TODO: Decide on if keep or not. NOT ON OG UML CLASS DIAGRAM
	private int spacesLeft; 
	private TreeSet<PartTimeTeachers> teacherTrainingAttendees;// TODO: Decide on if keep or not. NOT ON OG UML CLASS DIAGRAM
	*/

	private ArrayList<TimetableDate> trainingTimes;
	private TreeSet<String> taughtSkillSet;

	//TODO: Answer Q, maybe add more constructors
	// Q: >1 constructor required (with accompanying getters/setters?) if we don't have all these details??) Or do we not want anyone to modify the specific course once it is created?	
	public TeacherTrainingCourse(String inputCourseName, String inputCourseDesc, int inputMaxCapacity, ArrayList<TimetableDate> inputTrainingTimes, TreeSet<String> inputTaughtSkills){
		super(inputCourseName, inputCourseDesc);
		this.courseID = totalTeacherTrainingCourseIDs++;
		
		this.maxCourseCapacity = inputMaxCapacity;
		this.trainingTimes = inputTrainingTimes;
		this.taughtSkillSet = inputTaughtSkills;
		
		/* TODO: Decide if needed or not
		this.teacherTrainingAttendees = new ArrayList<PartTimeTeachers>;
		this.spacesLeft = this.maxCourseCapacity;
		*/
	}
	
	
	// Return maximum course capacity for the teacher training course
	public int getTeacherTrainingClassSize(){
		return maxCourseCapacity;
	}
		
	// Returns list of times scheduled for the teacher training course
	public ArrayList<TimetableDate> getTrainingTimes(){
		return trainingTimes;
	}
	
	// Returns list of skillsets taught in the teacher training course
	public TreeSet<String> getTaughtSkillSet(){
		return taughtSkillSet;
	}




	
		/* TODO: DETERMINE IF NEEDED */
	/*
	// Methods for adding/removing part time teachers to the attendees set
	// Return remaining spaces left for the teacher training course
	public int getSpacesLeft(){
		return spacesLeft;
	}

	// Add part-time teacher to the training course and update spaces remaining
	public void addAttendee(PartTimeTeacher newAttendee){
		if(spacesLeft > 0){
			teacherTrainingAttendees.add(newAttendee);
			spacesLeft--;		
		}
		//TODO: DECIDE ON ACTION HERE
		else{
			System.out.println("Teacher Training Course Full!");
		}
	}
	// Remove part-time teacher from the training course and update spaces remaining
	public void removeAttendee(PartTimeTeacher attendeeToRemove){
		if(spacesLeft < maxCourseCapacity && spacesLeft >= 0){
			teacherTrainingAttendees.remove(attendeeToRemove);
			spacesLeft++;
		}
		else if(spacesLeft == maxCourseCapacity){
			// TODO: DOSOMETHING... necessary?
		}
	}
	// Clear all part-time teachers from the training course and update spaces remaining
	public void clearAttendees(){
		teacherTrainingAttendees.clear();
		spacesLeft = this.maxCourseCapacity;
	}
	*/

}
