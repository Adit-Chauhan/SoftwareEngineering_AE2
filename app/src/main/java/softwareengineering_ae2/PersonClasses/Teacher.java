package softwareengineering_ae2.PersonClasses;

import softwareengineering_ae2.TimetableDate.TimetableDate;

import java.util.ArrayList;

public class Teacher extends Staff{
	private int teacherID;
	private int age;
	private String teacherName;
	private String title;
	boolean hasCompletedTraining;
	ArrayList<TimetableDate> availableTimes;
	ArrayList<String> teacherSkillSet;
	
	public Teacher(String teacherName, int age, int teacherID, String title) {
		super(teacherName, age, teacherID, title);
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