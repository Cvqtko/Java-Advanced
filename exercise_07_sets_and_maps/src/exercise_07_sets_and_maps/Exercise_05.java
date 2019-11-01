package exercise_07_sets_and_maps;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercise_05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, String[]> students = new TreeMap<>();
		int studentsCount = Integer.parseInt(scanner.nextLine());

		while (studentsCount-- > 0) {
			String studentName = scanner.nextLine();
			String[] studentGrades = scanner.nextLine().split(" ");

			students.put(studentName, studentGrades);
		}

		for (Map.Entry<String, String[]> studentEntry : students.entrySet()) {
			double average = 0;
			String[] score = studentEntry.getValue();
			for (int i = 0; i < score.length; i++) {
				average += Double.parseDouble(score[i]);
			}
			average = average / score.length;

			System.out.printf("%s is graduated with %s\n", studentEntry.getKey(), average);
		}

	}
}
