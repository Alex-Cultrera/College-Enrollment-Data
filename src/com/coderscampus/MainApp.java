package com.coderscampus;

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
		
		
		FileService fileService = new FileService();
				
				
				
			


	}

}
