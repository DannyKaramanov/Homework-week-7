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
		JFrame frame = new JFrame("Студенти");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("Списък със студенти", JLabel.CENTER);

		DataModel DataModel = new DataModel(studentList);
		table = new JTable(DataModel);
		for (Person person : people) {
			studentList.add(person);
		}

		JScrollPane scrollPane = new JScrollPane(table);

		// Добавяме бутон за сортиране
		JButton buttonSort = new JButton("Сортиране");

		// Добавяме бутон за филтриране
		JButton LastNameFilter = new JButton("Филтрирай по фамилия");

		// Добавяме бутон за справка за студенти с еднакво първо име
		JButton buttonSameName = new JButton("Студенти с еднакво име");

		// Добавяме панел, където ще поставим бутоните
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(buttonSort);
		buttonsPanel.add(LastNameFilter);
		buttonsPanel.add(buttonSameName);

		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(label, BorderLayout.NORTH);
		container.add(scrollPane, BorderLayout.CENTER);

		// Добавяме панелът с бутоните в контейнера
		container.add(buttonsPanel, BorderLayout.SOUTH);
		// Добавяме диалог
		final JDialog sortDialog = new CustomDialog(getSortText(), this, EType.SORT);

		// Добавяме listener към бутона за сортиране
		buttonSort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sortDialog.pack();
				sortDialog.setVisible(true);
			}
		});
		

		// Добавяме listener за филтрация
		LastNameFilter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String typedText = JOptionPane.showInputDialog("Моля, въведете фамилията по която искате да търсите");
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
		return "Моля, въведете цифрата, по която да се сортират данните: \n" + " 1 - Име по възходящ ред \n"
				+ " 2 - Име по низходящ ред \n" + "\n" + " 3 - Презиме по възходящ ред \n"
				+ " 4 - Презиме по низходящ ред\n" + "\n" + " 5 - Фамилия по възходящ ред \n"
				+ " 6 - Фамилия по низходящ ред\n";
	}

}
