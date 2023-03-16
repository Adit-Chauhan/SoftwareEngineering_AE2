package softwareengineering_ae2.CourseClasses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import softwareengineering_ae2.TimetableDate.TimetableDate;

import java.util.ArrayList;
import java.util.HashSet;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

/**
*	TeacherTrainingCourse class: Defines further attributes and methods specific to Teacher training courses. Extends Course Abstract class.
*	Methods from here are also used in the TeacherTrainingCourseDetailsBuilder.java Builder Class, as well as Administrator.java.
*
* @see: TeacherTrainingCourseDetailsBuilder.java
* @see: Administrator.java
*
*/
public class TeacherTrainingCourse extends Course {
	private int maxCourseCapacity;
	private ArrayList<TimetableDate> trainingTimes;
	private int spacesLeft; 
	private HashSet<Teacher> teacherTrainingAttendees;


	// Simple constructor left in to add teacher training course ID
	public TeacherTrainingCourse(){
		super();
	}


		/*	SETTERS	*/
	// NOTE: Class also has setters for course name, description and skillset inherited from Course abstract class

	// Sets maximum course capacity for the teacher training course
	public void setTeacherTrainingClassSize(int inputMaxCourseCapacity){
		this.maxCourseCapacity = inputMaxCourseCapacity;
	}
		
	// Sets list of times scheduled for the teacher training course
	public void setTrainingTimes(ArrayList<TimetableDate> inputTrainingTimes){
		this.trainingTimes = inputTrainingTimes;
	}
	
	
		/*	GETTERS	*/
	// NOTE: Class also has getters for course name, description, ID, and skillset inherited from Course abstract class
	// Return maximum course capacity for the teacher training course
	public int getTeacherTrainingClassSize(){
		return maxCourseCapacity;
	}
		
	// Returns list of times scheduled for the teacher training course
	public ArrayList<TimetableDate> getTrainingTimes(){
		return trainingTimes;
	}
	

	// Methods for adding/removing part time teachers to the attendees set
	// Return remaining spaces left for the teacher training course
	public int getSpacesLeft(){
		return spacesLeft;
	}

	
			/*	METHODS FOR ADDING/REMOVING TEACHERS TO/FROM THE TRAINING COURSE	*/
	// Add teacher to the training course and update spaces remaining
	public void addAttendee(Teacher newAttendee){
		if(spacesLeft > 0){
			teacherTrainingAttendees.add(newAttendee);
			spacesLeft--;		
		}
		else{
			System.out.println("Teacher Training Course Full!");
		}
	}
	
	// Check if a teacher is on the list for the training course
	public String checkAttendee(Teacher t){
		String outcome = String.format("Nope! %s. s is not on the list for %s", t.getTitle(), t.getTeacherName(), this.getCourseName());
		
		if(teacherTrainingAttendees.contains(t)){
			outcome = String.format("Yep! %s. %s is on the list for %s", t.getTitle(), t.getTeacherName(), this.getCourseName());
		}
		
		return outcome; 
	}

	
	// Return the complete list of all attendees of the teacher training course
	public String listAttendees(){
		String list = "List of all attendees:\n";
		
		for(Teacher t : teacherTrainingAttendees){
			list += t.getTitle()+". "+t.getTeacherName()+"\n";
		}
		
		return list;	
	}

	// Remove teacher from the training course and update spaces remaining
	public void removeAttendee(Teacher attendeeToRemove){
		if(spacesLeft < maxCourseCapacity && spacesLeft >= 0){
			teacherTrainingAttendees.remove(attendeeToRemove);
			spacesLeft++;
		}
		else if(spacesLeft == maxCourseCapacity){
			System.out.println("Cannot remove teachers: Teacher Training Course Empty!");
		}
	}
	
	// Clear all teachers from the training course and update spaces remaining
	public void clearAttendees(){
		teacherTrainingAttendees.clear();
		spacesLeft = this.maxCourseCapacity;
	}

}
