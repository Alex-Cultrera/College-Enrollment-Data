package com.coderscampus;

import java.util.Comparator;

public class StudentComparator implements Comparator<EnrolledStudent> {

	@Override
	public int compare(EnrolledStudent student1, EnrolledStudent student2) {
		if (student1 == null && student2 == null) {
			return 0;
		} else if (student1 == null) {
			return -1;
		} else if (student2 == null) {
			return 1;
		}
		return Integer.compare(student2.getGrade(), student1.getGrade());
	}

}
