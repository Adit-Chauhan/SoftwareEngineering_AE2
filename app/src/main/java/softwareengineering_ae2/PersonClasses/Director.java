package softwareengineering_ae2.PersonClasses;

import softwareengineering_ae2.CourseClasses.StudentCourseRequirements;
import softwareengineering_ae2.CourseClasses.StudentCourseRequirementsBuilder;
import softwareengineering_ae2.TimetableDate.TimetableDate;
import softwareengineering_ae2.datastore.StudentCourseStore;

import java.io.IOException;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Scanner;

/**
 * This class represents the director and has a method to creat and add courseRequiremnt.
 *
 */

public class Director extends Staff {
	StudentCourseStore courses;
	public Director(String n, int a, int id, String title) throws IOException {
		super(n, a, title);
		courses = StudentCourseStore.getInstance();
	}

	//This method will be called to create a courseRequiement and add it to database.
	public void addRequirments() {
		Scanner r = new Scanner(System.in);
		boolean t = true;
		String courseName = null;
		String courseDescription = null;
		int year = 0;
		int month = 0;
		int date = 0;
		int time = 0;
		HashSet<String> skills = new HashSet<String>();
		String skillInput;
		
		//create course name
		while(t) {
			System.out.println("Please input course name: ");
			courseName = r.nextLine();
			if(courseName != null) {
				break;
			}else {
				System.out.println("Invalid value. You must input a course name.");
			}
		}
		
		//create course description
		while(t) {
			System.out.println("Please input course name: ");
			courseDescription = r.nextLine();
			if(courseDescription != null) {
				break;
			}else {
				System.out.println("Invalid value. You must enter course description");
			}
		}
		
		//create a date and time
		while(t) {
			System.out.println("Please input the year for this course: ");
			year = r.nextInt();
			if(year == 2023 || year == 2024) {
				break;
			}else {
				System.out.println("Invalid value. The year must be 2023 or 2024.");
			}
		}
		
		while(t) {
			System.out.println("Please input the month for this course: ");
			month = r.nextInt();
			if(month >= 1 && month <= 12) {
				break;
			}else {
				System.out.println("Invalid value. The month must be from 1 to 12.");
			}
		}
		
		while(t) {
			System.out.println("Please input the date for this course: ");
			date = r.nextInt();
			YearMonth yearMonth = YearMonth.of(year, month);
			int maxDays = yearMonth.lengthOfMonth();
			if(date >= 1 && date <= maxDays) {
				break;
			}else {
				System.out.println("Invalid value. The date must be between 1 and " + maxDays + " .");
			}
		}
		
		while(t) {
			System.out.println("Please input the time for this course: ");
			time = r.nextInt();
			if(time >= 1 && time <= 24) {
				break;
			}else {
				System.out.println("Invalid value. The time must be between 1 and 24.");
			}
		}
		
		ZonedDateTime zonedDateTime = ZonedDateTime.of(year, month, date, time, 0, 0, 0, ZoneId.of("Europe/London"));

		TimetableDate timeTable = new TimetableDate(date,month,year);
		
		//create skills hashset
		while(t) {
			System.out.println("Please input the Skills required for this course. Please input end to terminate this step.");
			skillInput = r.nextLine();
			if(skillInput.equals("end")) {
				break;
			}
			if (skillInput == null) {
				System.out.println("Invalid value. Please entre a skill or end.");
			}else {
				skills.add(skillInput);
			}
		}
		
		//create course
		var builder = new StudentCourseRequirementsBuilder();
		builder.addName(courseName);
		builder.addDesc(courseDescription);
		builder.addSkills(skills);
		builder.addStudentCourseDateTime(timeTable);
		
		StudentCourseRequirements studentCourse = builder.getCourseRelatedObject();
		courses.add(studentCourse);
	}
}
