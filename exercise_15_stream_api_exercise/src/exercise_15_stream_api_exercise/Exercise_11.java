package exercise_15_stream_api_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercise_11 {
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();

		List<StudentSpecialty> studentSpecialties = new ArrayList<>();
		List<Student> students = new ArrayList<>();

		while (!"Students:".equals(line)) {
			String[] tokens = line.split("\\s+");
			String speciality = tokens[0] + " " + tokens[1];
			String facultyNumber = tokens[2];

			StudentSpecialty studentSpecialty = new StudentSpecialty(speciality, facultyNumber);

			studentSpecialties.add(studentSpecialty);
			line = reader.readLine();
		}

		line = reader.readLine();
		while (!"END".equals(line)) {
			String[] tokens = line.split("\\s+");
			line = reader.readLine();

			String facultyNumber = tokens[0];
			String studentName = tokens[1] + " " + tokens[2];

			Student student = new Student(studentName, facultyNumber);
			students.add(student);
		}

		students.sort(Comparator.comparing(Student::getStudentName));

		List<String> joined = new ArrayList<>();
		studentSpecialties.stream().forEach(speciality -> students.stream().forEach(student -> {
			if (speciality.getFacultyNumber().equals(student.getFacultyNumber())) {
				joined.add(String.format("%s %s %s", student.getStudentName(), student.getFacultyNumber(),
						speciality.getSpecialtyName()));
			}
		}));

		Collections.sort(joined);

		joined.stream().forEach(System.out::println);
	}
}

class StudentSpecialty {
	String specialtyName;
	String facultyNumber;

	public StudentSpecialty(String specialtyName, String facultyNumber) {
		this.specialtyName = specialtyName;
		this.facultyNumber = facultyNumber;
	}

	public String getSpecialtyName() {
		return specialtyName;
	}

	public String getFacultyNumber() {
		return facultyNumber;
	}
}

class Student {
	String studentName;
	String facultyNumber;

	public Student(String studentName, String facultyNumber) {
		this.studentName = studentName;
		this.facultyNumber = facultyNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getFacultyNumber() {
		return facultyNumber;
	}
}