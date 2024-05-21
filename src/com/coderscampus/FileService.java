package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileService {

public StudentEnrollment[] getStudentFromFile () {
		
		BufferedReader fileReader = null;
		int numberOfStudents = 100;
		
		try {
			int i = 0;
			String line = null;
			StudentEnrollment[] students = new StudentEnrollment[numberOfStudents];
			fileReader = new BufferedReader(new FileReader("student-master-list.csv"));
			
			while ((line = fileReader.readLine()) != null) {
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
	
	
}
