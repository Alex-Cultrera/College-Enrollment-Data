package com.coderscampus;

import java.util.Comparator;

public class EnrolledStudent implements Comparator<EnrolledStudent> {

	private Integer studentID;
	private String studentName;
	private String course;
	private Integer grade;
	
	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	public EnrolledStudent(Integer studentID, String studentName, String course, Integer grade) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.course = course;
		this.grade = grade;
	}

	
	@Override
	public int compare(EnrolledStudent student1, EnrolledStudent student2) {
			return student1.getGrade().compareTo(student2.getGrade());
		}


	
}
