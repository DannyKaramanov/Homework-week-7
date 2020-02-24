package students;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import students.Person;

public class DataModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Person> studentList = new ArrayList<>();

	// constructor
	public DataModel(ArrayList<Person> studentList) {
		this.studentList = studentList;
	}

	@Override
	public int getColumnCount() {
		return 3; // брой колони в таблицата
	}

	@Override
	public int getRowCount() {
		return studentList.size(); // брой редове в таблицата
	}

	@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch (columnIndex) {
				case 0:
					return studentList.get(rowIndex).getfName();
				case 1:
					return studentList.get(rowIndex).getMidName();
				case 2:
					return studentList.get(rowIndex).getlName();
			} 
			return null;
		}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Име";
		case 1:
			return "Презиме";
		case 2:
			return "Фамилия";

		default:
			return super.getColumnName(column);
		}
	}
}
