package softwareengineering_ae2.PersonClasses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import softwareengineering_ae2.TimetableDate.TimetableDate;

import java.util.ArrayList;
/**
 * This class is for containing information of part-time teachers
 *
 */

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Teacher extends Staff{
	private String teacherName;
	private String title;
	boolean hasCompletedTraining;

	boolean isAssigned;
	ArrayList<TimetableDate> availableTimes;
	ArrayList<String> teacherSkillSet;

	public Teacher(){
		super();
	}
	public Teacher(String teacherName, int age, String title) {
		super(teacherName, age, title);
		hasCompletedTraining = false;
		availableTimes = new ArrayList<TimetableDate>();
		teacherSkillSet = new ArrayList<String>();
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public boolean getTrainingCompletedStatus() {
		return hasCompletedTraining;
	}

	public void setTrainingCompletedStatus(boolean hasCompletedTraining) {
		this.hasCompletedTraining = hasCompletedTraining;
	}

	public ArrayList<TimetableDate> getTeacherAvailability() {
		return availableTimes;
	}

	public void setTeacherAvailability(ArrayList<TimetableDate> availableTimes) {
		this.availableTimes = availableTimes;
	}

	public ArrayList<String> getTeacherSkillSet() {
		return teacherSkillSet;
	}

	public void setTeacherSkillSet(ArrayList<String> teacherSkillSet) {
		this.teacherSkillSet = teacherSkillSet;
	}

	public boolean isAssigned() {
		return isAssigned;
	}

	public void setAssigned(boolean assigned) {
		isAssigned = assigned;
	}
}