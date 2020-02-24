package comparators;

import students.Person;

public class MidNameComparator extends StudentComparator {

	@Override
	public int compare(Person student1, Person student2) {
		if (student1.getMidName().equals(student2.getMidName())) {
			return 0;
		}else {
			return (student1.getMidName().compareTo(student2.getMidName()) * sortOrder);
		}
	}
}
