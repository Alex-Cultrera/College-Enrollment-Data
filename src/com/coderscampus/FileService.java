package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileService {

private String fileName = "student-master-list.csv";
private String invalidStudent = "Student ID";

	
	
public StudentEnrollment[] getStudentFromFile (int numberOfStudents) {
		
		BufferedReader fileReader = null;
				
		try {
			int i = 0;
			String line = null;
			StudentEnrollment[] students = new StudentEnrollment[numberOfStudents];
			fileReader = new BufferedReader(new FileReader(fileName));
			
			while ((line = fileReader.readLine()) != null) {
				if (line.contains(invalidStudent) == true) {
					line = fileReader.readLine();
				}
				String[] lineData = line.split(",");
				StudentEnrollment student = new StudentEnrollment(Integer.parseInt(lineData[0]), lineData[1], lineData[2], Integer.parseInt(lineData[3]));
				students[i] = student;
				i++;				
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
				userInfo = buffReader.readLine();
			}
			studentMasterListLength++;
			userInfo = buffReader.readLine();
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




	
}
