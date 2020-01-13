package exercise_04_intro_to_java;

import java.util.Scanner;

public class Exercise_09 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int countOfNumbers = Integer.parseInt(scanner.nextLine());

		int[] numbers = new int[countOfNumbers];
		for (int i = 0; i < countOfNumbers; i++) {
			int number = Integer.parseInt(scanner.nextLine());
			numbers[i] = number;
		}

		String line = scanner.nextLine();

		while (!"party over".equals(line)) {

			String[] tokens = line.split("\\s+");
			int pattern = Integer.parseInt(tokens[0]);
			int position = Integer.parseInt(tokens[1]);

			for (int i = 0; i < numbers.length; i++) {
				if (pattern == 1) {
					changeValueToOne(numbers, position);
				} else if (pattern == 0) {
					changeValueToZero(numbers, position);
				} else {
					changeValueByPosition(numbers, position);
				}
			}
			line = scanner.nextLine();
		}

		for (int number : numbers) {
			System.out.println(number);
		}
	}

	private static void changeValueToZero(int[] numbers, int position) {
		for (int i = 0; i < numbers.length; i++) {
			int a = numbers[i];
			int b = a >> position;
			int d = ~(1 << position);
			int result = a & d;
			numbers[i] = result;
		}
	}

	private static void changeValueToOne(int[] numbers, int position) {
		for (int i = 0; i < numbers.length; i++) {
			int a = numbers[i];
			int b = a >> position;
			int result = a | b;
			numbers[i] = result;
		}
	}

	private static void changeValueByPosition(int[] numbers, int position) {
		for (int i = 0; i < numbers.length; i++) {
			int a = numbers[i];
			int b = a >> position;
			int c = b & 1;
			if (c == 0) {
				int d = 1 << position;
				int result = a | b;
				numbers[i] = result;
			} else {
				int d = ~(1 << position);
				int result = a & d;
				numbers[i] = result;
			}
		}
	}
}
