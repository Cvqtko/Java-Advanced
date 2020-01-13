package exercise_03_intro_to_java;

import java.util.Scanner;

public class Exercise_02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String firstWord = scanner.next("\\w+");
		String secondWord = scanner.next("\\w+");

		double firstNum = scanner.nextDouble();
		double secondNum = scanner.nextDouble();
		double thirdNum = scanner.nextDouble();
		scanner.nextLine();
		String thirdLine = scanner.nextLine();
		
		double sum  = firstNum + secondNum + thirdNum;

		System.out.printf("%s %s %s %.2f", firstWord, secondWord, thirdLine, sum);
	}
}
