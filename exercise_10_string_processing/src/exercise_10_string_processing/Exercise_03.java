package exercise_10_string_processing;

import java.util.Scanner;

public class Exercise_03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		int position = text.indexOf("<upcase>");

		while (position != -1) {
			text = text.substring(0, position) + text.substring(position + 8, text.indexOf("</upcase>")).toUpperCase()
					+ text.substring(text.indexOf("</upcase>") + 9);
			position = text.indexOf("<upcase>", position + 1);
		}
		System.out.println(text);
	}
}