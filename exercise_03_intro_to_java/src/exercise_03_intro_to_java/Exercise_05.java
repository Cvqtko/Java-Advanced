package exercise_03_intro_to_java;

import java.util.Scanner;

public class Exercise_05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String firstName = scanner.nextLine();
		String secondName = scanner.nextLine();

		if (firstName != null && firstName.isEmpty()) {
			firstName = "*****";
		}
		System.out.printf("Hello, %s %s",firstName,secondName);
	}
}
