package softwareengineering_ae2.CourseClasses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.util.HashSet;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TeacherTrainingCourse extends Course {
	private static int totalTeacherTrainingCourseIDs = 0;
	private int maxCourseCapacity;
	private ArrayList<TimetableDate> trainingTimes;
	private HashSet<String> taughtSkillSet;

	/*// TODO: Decide on if keep or not. NOT ON OG UML CLASS DIAGRAM
	private int spacesLeft; 
	private HashSet<PartTimeTeachers> teacherTrainingAttendees;// TODO: Decide on if keep or not. NOT ON OG UML CLASS DIAGRAM
	*/


	// Simple constructor left in to add student course ID
	public TeacherTrainingCourse(){
		this.courseID = totalTeacherTrainingCourseIDs++;
	}


		/*	SETTERS	*/
	// NOTE: Class also has setters for course name and description inherited from Course abstract class

	// Sets maximum course capacity for the teacher training course
	public void setTeacherTrainingClassSize(int inputMaxCourseCapacity){
		this.maxCourseCapacity = inputMaxCourseCapacity;
	}
		
	// Sets list of times scheduled for the teacher training course
	public void setTrainingTimes(ArrayList<TimetableDate> inputTrainingTimes){
		this.trainingTimes = inputTrainingTimes;
	}
	
	// Sets list of skillsets taught in the teacher training course
	public void setTaughtSkillSet(HashSet<String> inputTaughtSkillSet){
		this.taughtSkillSet = inputTaughtSkillSet;
	}

	
		/*	GETTERS	*/
	// NOTE: Class also has getters for course name, description and course ID, inherited from Course abstract class
	// Return maximum course capacity for the teacher training course
	public int getTeacherTrainingClassSize(){
		return maxCourseCapacity;
	}
		
	// Returns list of times scheduled for the teacher training course
	public ArrayList<TimetableDate> getTrainingTimes(){
		return trainingTimes;
	}
	
	// Returns list of skillsets taught in the teacher training course
	public HashSet<String> getTaughtSkillSet(){
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
