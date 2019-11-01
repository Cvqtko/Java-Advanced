package exercise_10_string_processing;

import java.util.Scanner;

public class Exercise_01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] tokens = input.split("[,\\s-]+");
		double avg = 0;

		for (int i = 1; i < tokens.length; i++) {
			avg += Double.parseDouble(tokens[i]);
			if (i == tokens.length - 1) {
				avg /= 3;
			}
		}

		System.out.printf("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|\n","Name","JAdv","JavaOOP","AdvOOP","Average");
		System.out.printf("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|",
				tokens[0],Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]),avg);
	}
}
