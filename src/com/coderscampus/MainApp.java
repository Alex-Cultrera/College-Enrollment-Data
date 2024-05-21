package com.coderscampus;

import java.util.Arrays;

public class MainApp {

	public static void main(String[] args) {
		// SITUATION:
		// 3 different professors
		// each have their own course enrollment list of students
		// one CSV file containing master list of all students across all courses
		// each professor only wants to see list of their own students
		
		// OBJECTIVE:
		// parse the Master List separating the data into 3 separate CSV files
		// group the students into separate CSVs by course 
		// each CSV should sort the students by grade in descending order
		// the CSV output file names should be called: 
		// course1.csv
		// course2.csv
		// course3.csv
		
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
		int x=0;
		int y=0;
		int z=0;
		for (EnrolledStudent student : studentMasterList) {
			if (student.getCourse().contains(compsciCourseCode)) {
				COMPSCI csStudent = new COMPSCI(student.getStudentID(), student.getStudentName(), student.getCourse(), student.getGrade());
				COMPSCI[] csStudents = new COMPSCI[fileService.calculateStudentListLengthByCourse(compsciCourseCode)];
				csStudents[x] = csStudent;
				x++;
			}
			if (student.getCourse().contains(statCourseCode)) {
				STAT statStudent = new STAT(student.getStudentID(), student.getStudentName(), student.getCourse(), student.getGrade());
				STAT[] statStudents = new STAT[fileService.calculateStudentListLengthByCourse(statCourseCode)];
				statStudents[y] = statStudent;
				y++;
			}
			if (student.getCourse().contains(apmthCourseCode)) {
				APMTH apmthStudent = new APMTH(student.getStudentID(), student.getStudentName(), student.getCourse(), student.getGrade());
				APMTH[] apmthStudents = new APMTH[fileService.calculateStudentListLengthByCourse(apmthCourseCode)];
				apmthStudents[z] = apmthStudent;
				z++;
			}
		}

		
		

	}

}
