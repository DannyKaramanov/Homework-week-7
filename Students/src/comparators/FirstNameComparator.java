package comparators;

import students.Person;

public class FirstNameComparator extends StudentComparator {

	@Override
	public int compare(Person student1, Person student2) {
		if (student1.getfName().equals(student2.getfName())) {
			return 0;
		}else {
			return (student1.getfName().compareTo(student2.getfName()) * sortOrder);
		}
	}

}
