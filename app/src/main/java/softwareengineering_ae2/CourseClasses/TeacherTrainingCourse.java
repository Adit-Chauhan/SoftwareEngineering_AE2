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
	private HashSet<String> taughtSkillSet;
	private String teacherSet;

	/*// TODO: Decide on if keep or not. NOT ON OG UML CLASS DIAGRAM
	private int spacesLeft; 
	private HashSet<PartTimeTeachers> teacherTrainingAttendees;// TODO: Decide on if keep or not. NOT ON OG UML CLASS DIAGRAM
	*/


	// Simple constructor left in to add student course ID
	public TeacherTrainingCourse(){
		super();
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

	public void setTeacher(String name){
		this.teacherSet = name;
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
