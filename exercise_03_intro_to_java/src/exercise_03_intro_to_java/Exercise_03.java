package exercise_03_intro_to_java;

import java.util.Scanner;

public class Exercise_03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double firstNum = scanner.nextDouble();
		double secondNum = scanner.nextDouble();
		double thirdNum = scanner.nextDouble();

		double sum = firstNum + secondNum + thirdNum;
		double average = sum / 3;

		System.out.printf("%.2f", average);
	}
}
