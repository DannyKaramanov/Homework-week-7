package students;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SortOrder;

import comparators.FirstNameComparator;
import comparators.LastNameComparator;
import comparators.MidNameComparator;
import comparators.StudentComparator;
import fileReader.FileReader;

public class DataGUI {

	public static Person[] student;
	Person[] people = FileReader.readStudents();
	ArrayList<Person> studentList = new ArrayList<>();
	JTable table;

	public void createAndShowGUI() {
		JFrame frame = new JFrame("��������");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("������ ��� ��������", JLabel.CENTER);

		DataModel DataModel = new DataModel(studentList);
		table = new JTable(DataModel);
		for (Person person : people) {
			studentList.add(person);
		}

		JScrollPane scrollPane = new JScrollPane(table);

		// �������� ����� �� ���������
		JButton buttonSort = new JButton("���������");

		// �������� ����� �� ����������
		JButton LastNameFilter = new JButton("��������� �� �������");

		// �������� ����� �� ������� �� �������� � ������� ����� ���
		JButton buttonSameName = new JButton("�������� � ������� ���");

		// �������� �����, ������ �� �������� ��������
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(buttonSort);
		buttonsPanel.add(LastNameFilter);
		buttonsPanel.add(buttonSameName);

		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(label, BorderLayout.NORTH);
		container.add(scrollPane, BorderLayout.CENTER);

		// �������� ������� � �������� � ����������
		container.add(buttonsPanel, BorderLayout.SOUTH);
		// �������� ������
		final JDialog sortDialog = new CustomDialog(getSortText(), this, EType.SORT);

		// �������� listener ��� ������ �� ���������
		buttonSort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sortDialog.pack();
				sortDialog.setVisible(true);
			}
		});
		

		// �������� listener �� ���������
		LastNameFilter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String typedText = JOptionPane.showInputDialog("����, �������� ��������� �� ����� ������ �� �������");
				for (int i = 0; i < studentList.size(); i++) {
					for (int j = i; j < studentList.size(); j++) {
						if (!(studentList.get(i).getlName().equals(typedText))) {
							studentList.remove(i);
						}
					}

				}
				table.repaint();
			}
		});

		buttonSameName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				

			}
		});

		frame.setVisible(true);
	}

	public void sortTable(int intValue, JTable table, Person[] person) {
		StudentComparator comparator = null;

		switch (intValue) {
		case 1:
			comparator = new FirstNameComparator();
			comparator.setSortOrder(SortOrder.ASCENDING);
			break;
		case 2:
			comparator = new FirstNameComparator();
			comparator.setSortOrder(SortOrder.DESCENDING);
			break;
		case 3:
			comparator = new MidNameComparator();
			comparator.setSortOrder(SortOrder.ASCENDING);
			break;
		case 4:
			comparator = new MidNameComparator();
			comparator.setSortOrder(SortOrder.DESCENDING);
			break;
		case 5:
			comparator = new LastNameComparator();
			comparator.setSortOrder(SortOrder.ASCENDING);
			break;
		case 6:
			comparator = new LastNameComparator();
			comparator.setSortOrder(SortOrder.DESCENDING);
			break;
		}
		table.repaint();
	}

	private static String getSortText() {
		return "����, �������� �������, �� ����� �� �� �������� �������: \n" + " 1 - ��� �� �������� ��� \n"
				+ " 2 - ��� �� �������� ��� \n" + "\n" + " 3 - ������� �� �������� ��� \n"
				+ " 4 - ������� �� �������� ���\n" + "\n" + " 5 - ������� �� �������� ��� \n"
				+ " 6 - ������� �� �������� ���\n";
	}

}
