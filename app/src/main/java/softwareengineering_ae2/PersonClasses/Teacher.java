package softwareengineering_ae2.PersonClasses;

import java.util.ArrayList;

public class Teacher extends Person{
	private int teacherID;
	private int age;
	private String teacherName;
	boolean hasCompletedTraining;
	ArrayList<TimetableDate> availableTimes;
	ArrayList<String> teacherSkillSet;
	
	public Teacher(int teacherID, int age, String teacherName) {
		this.teacherID = teacherID;
		this.age = age;
		this.teacherName = teacherName;
		hasCompletedTraining = false;
		availableTimes = new ArrayList<TimetableDate>();
		teacherSkillSet = new ArrayList<String>();
	}

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
	
	
}