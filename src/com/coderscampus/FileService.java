package com.coderscampus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileService {

private String fileName = "student-master-list.csv";
private String invalidStudent = "Student ID";
	
public EnrolledStudent[] getStudentFromFile (int numberOfStudents) {
		
		BufferedReader fileReader = null;
				
		try {
			int i = 0;
			String line = null;
			EnrolledStudent[] students = new EnrolledStudent[numberOfStudents];
			fileReader = new BufferedReader(new FileReader(fileName));
			
			while ((line = fileReader.readLine()) != null) {
				if (line.contains(invalidStudent) == true) {
					i=i+0;
				}
				else {
					String[] lineData = line.split(",");
					EnrolledStudent student = new EnrolledStudent(Integer.parseInt(lineData[0]), lineData[1], lineData[2], Integer.parseInt(lineData[3]));
					students[i] = student;
					i++;		
				}
						
			}
			return students;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			return null;
		}
	
public int calculateMasterListLength() {
	int studentMasterListLength = 0;
	BufferedReader buffReader;
	try {
		buffReader = new BufferedReader(new FileReader(fileName));
		String userInfo = buffReader.readLine();
		while (userInfo != null) {
			if (userInfo.contains(invalidStudent) == true) {
				studentMasterListLength = studentMasterListLength + 0;
				userInfo = buffReader.readLine();
			}
			else {
				studentMasterListLength++;
				userInfo = buffReader.readLine();
			}
			
		}
	} catch (FileNotFoundException e) {
		System.out.println("Oops, the file wasn't found");
		e.printStackTrace(); 
	} catch (IOException e) {
		System.out.println("Oops, there was an I/O Exception");
		e.printStackTrace();
	}		
	return studentMasterListLength;
}

public int calculateStudentListLengthByCourse(String courseCode) {
	int listLength = 0;
	BufferedReader buffReader;
	try {
		buffReader = new BufferedReader(new FileReader(fileName));
		String userInfo = buffReader.readLine();
		while (userInfo != null) {
			if (userInfo.contains(courseCode) == true) {
				listLength++;
				userInfo = buffReader.readLine();
			}
			else {
				listLength = listLength + 0;
				userInfo = buffReader.readLine();
			}
			
		}
	} catch (FileNotFoundException e) {
		System.out.println("Oops, the file wasn't found");
		e.printStackTrace(); 
	} catch (IOException e) {
		System.out.println("Oops, there was an I/O Exception");
		e.printStackTrace();
	}		
	return listLength;
}

public void writeStudentToFile(String nameOfFile, EnrolledStudent[] students) throws IOException {
	BufferedWriter writer = null;

	try {
		writer = new BufferedWriter(new FileWriter(nameOfFile));
		writer.write("Student ID" + ", " + "Student Name" + ", " + "Course" + ", " + "Grade" + "\n");
		for (EnrolledStudent student : students) {
			writer.write(student.getStudentID() + ", " + student.getStudentName() + ", " + student.getCourse() + ", " + student.getGrade() + "\n");
		}
	} finally {
		if (writer != null) writer.close();
	}
	
}

	
}
