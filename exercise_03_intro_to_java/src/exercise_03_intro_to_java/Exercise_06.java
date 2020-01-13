package exercise_03_intro_to_java;

import java.util.Scanner;

public class Exercise_06 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double distance = Double.parseDouble(scanner.nextLine());
		String dayTime = scanner.nextLine();

		double price;
		double charge;

		if (distance > 0 && distance < 20) {
			if ("night".equals(dayTime)) {
				charge = 0.9;
			} else {
				charge = 0.79;
			}
			price = charge * distance + 0.7;
		} else if (distance < 100) {
			price = 0.09 * distance;
		} else {
			price = 0.06 * distance;
		}
		System.out.printf("%.2f", price);
	}
}
