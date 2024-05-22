package com.coderscampus;

import java.io.IOException;
import java.util.Arrays;


public class MainApp {

	public static void main(String[] args) throws IOException {
			
		// HINTS:
		// If trying to use Arrays.sort(yourArray), and yourArray contains null values, the sort will crash (will need to learn how to handle null entries)
		// when writing to a file, you can use "\n" to write a new line to the file (example, fileWriter.write("This is one line \n")
		// to convert String input to an Integer, you can parse it like so: Integer myIntVal = Integer.parseInt(myStringVal)
		
		String compsciCourseCode = "COMPSCI";
		String compsciFileName = "course1.csv";
		
		
		String statCourseCode = "STAT";
		String statFileName = "course2.csv";
		
		
		String apmthCourseCode = "APMTH";
		String apmthFileName = "course3.csv";
		
			
		System.out.println("Master List of Enrolled Students:");
		System.out.println("\n");
		System.out.println("Student ID, Student Name, Course, Grade");
		System.out.println("\n");
		
		// import of master list of students into an array
		FileService fileService = new FileService();
		EnrolledStudent[] studentMasterList = fileService.getStudentFromFile(fileService.calculateMasterListLength());
		for (EnrolledStudent student : studentMasterList) {
			System.out.println(student.getStudentID() + ", " + student.getStudentName() + ", " + student.getCourse() + ", " + student.getGrade());
		}
		
		System.out.println("\n");
		
		// parse the master list by course
		COMPSCI[] csStudents = new COMPSCI[fileService.calculateStudentListLengthByCourse(compsciCourseCode)];
		STAT[] statStudents = new STAT[fileService.calculateStudentListLengthByCourse(statCourseCode)];
		APMTH[] apmthStudents = new APMTH[fileService.calculateStudentListLengthByCourse(apmthCourseCode)];
		int x=0;
		int y=0;
		int z=0;
		for (EnrolledStudent student : studentMasterList) {
			if (student.getCourse().contains(compsciCourseCode) == true) {
				COMPSCI csStudent = new COMPSCI(student.getStudentID(), student.getStudentName(), student.getCourse(), student.getGrade());
				csStudents[x] = csStudent;
				x++;
			}
			else if (student.getCourse().contains(statCourseCode) == true) {
				STAT statStudent = new STAT(student.getStudentID(), student.getStudentName(), student.getCourse(), student.getGrade());
				statStudents[y] = statStudent;
				y++;
			}
			else if (student.getCourse().contains(apmthCourseCode) == true) {
				APMTH apmthStudent = new APMTH(student.getStudentID(), student.getStudentName(), student.getCourse(), student.getGrade());
				apmthStudents[z] = apmthStudent;
				z++;
			}
			else {
				System.out.println();
			}
						
		}
		
		// sort the students enrolled in each course by grade in descending order
		Arrays.sort(csStudents, new StudentComparator());
		
		Arrays.sort(statStudents, new StudentComparator());
		
		Arrays.sort(apmthStudents, new StudentComparator());

		// Print the list of students to test that the sort was effective
		System.out.println("\n");
		System.out.println("COMPSCI students sorted by grade: ");
		for (COMPSCI student : csStudents) {
			System.out.println(student.getStudentID() + ", " + student.getStudentName() + ", " + student.getCourse() + ", " + student.getGrade());
			fileService.writeCompsciStudentToFile(compsciFileName, student);
		}
		
		System.out.println("\n");
		System.out.println("STAT students sorted by grade: ");
		for (STAT student : statStudents) {
			System.out.println(student.getStudentID() + ", " + student.getStudentName() + ", " + student.getCourse() + ", " + student.getGrade());
			fileService.writeStatStudentToFile(statFileName, student);
		}
		
		System.out.println("\n");
		System.out.println("APMTH students sorted by grade: ");
		for (APMTH student : apmthStudents) {
			System.out.println(student.getStudentID() + ", " + student.getStudentName() + ", " + student.getCourse() + ", " + student.getGrade());
			fileService.writeApmthStudentToFile(apmthFileName, student);
		}
				
	}

}
