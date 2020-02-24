package comparators;

import students.Person;

public class LastNameComparator extends StudentComparator{

	@Override
	public int compare(Person student1, Person student2) {
		if (student1.getlName().equals(student2.getlName())) {
			return 0;
		}else {
			return (student1.getlName().compareTo(student2.getlName()) * sortOrder);
		}
	}

}
