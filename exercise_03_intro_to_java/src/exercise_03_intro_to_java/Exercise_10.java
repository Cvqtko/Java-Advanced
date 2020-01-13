package exercise_03_intro_to_java;

import java.util.Scanner;

public class Exercise_10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int num = scanner.nextInt();
		int bitPos = scanner.nextInt();

		int mask = num >> bitPos;

		int result = 1 & mask;

		System.out.println(result);

	}
}
