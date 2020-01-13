package exercise_04_intro_to_java;

import java.util.Scanner;

public class Exercise_10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		char[][] matrix = new char[8][32];

		for (int i = 0; i < 8; i++) {
			int number = Integer.parseInt(scanner.nextLine());

			char[] chars = Integer.toBinaryString(number).toCharArray();
			for (int j = 0; j < chars.length; j++) {
				matrix[i][j] = chars[j];
			}
		}
		String debug = "";
	}
}
