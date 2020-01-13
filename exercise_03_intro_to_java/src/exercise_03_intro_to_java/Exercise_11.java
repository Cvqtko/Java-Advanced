package exercise_03_intro_to_java;

import java.util.Scanner;

public class Exercise_11 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int number = scanner.nextInt();
		int bitPos = scanner.nextInt();
		int bitValue = scanner.nextInt();
		int result;
		
		if (bitValue == 0) {
			int mask = ~(1 << bitPos);
			result = number & mask;
		} else {
			int mask = 1 << bitPos;
			result = number | mask;
		}

		System.out.println(result);

	}
}
