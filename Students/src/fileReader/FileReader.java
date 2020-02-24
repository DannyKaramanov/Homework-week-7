package fileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import students.Person;

public class FileReader {

	private static final String PERSON_FILE_EXTENSION = ".file";
	private static final String PERSON_FILE_NAME = "students";
	private static final String FILE_PATH = "src/files/";
	private static final String FULL_PATH = FILE_PATH + PERSON_FILE_NAME + PERSON_FILE_EXTENSION;

	private static ArrayList<Person> studentList = new ArrayList<>();

	public static void createStudentFile() {
		File file = new File(FULL_PATH);
		file.getParentFile().mkdirs();

		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("Файлът не може да бъде създаден!");
			e.printStackTrace();
		}
	}

	public static boolean isFileExists() {
		File file = new File(FULL_PATH);
		return file.exists();
	}

	@SuppressWarnings("resource")
	public static Person[] readStudents() {
		try {
			FileInputStream fileStream = new FileInputStream(FULL_PATH);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileStream));
			String stringLine;

			while ((stringLine = bufferedReader.readLine()) != null) {
				String[] data = stringLine.split("\t");
				addStudent(data);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Person[] people = new Person[studentList.size()];
		return studentList.toArray(people);
	}

	private static void addStudent(String[] data) {

		// Име, Презиме, Фамилия
		Person person = new Person(data[0], data[1], data[2]);

		studentList.add(person);
	}
}
