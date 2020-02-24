package comparators;

import java.util.Comparator;

import javax.swing.SortOrder;

import students.Person;

public abstract class StudentComparator implements Comparator<Person>{
	protected int sortOrder = 1; 

	public void setSortOrder(SortOrder order) {
		if (order.equals(SortOrder.ASCENDING)) {
			this.sortOrder = -1;
		} else {
			this.sortOrder = 1;
		}
	}
	

}
