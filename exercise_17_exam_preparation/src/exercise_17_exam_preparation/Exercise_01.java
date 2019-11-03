package exercise_17_exam_preparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_01 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String line = reader.readLine();
		int countOfLines = 0;
		StringBuilder lines = new StringBuilder();

		while (!"Collect".equals(line)) {
			countOfLines++;
			lines.append(line).append(System.lineSeparator());

			line = reader.readLine();
		}
		Pattern patternCreateRegex = Pattern.compile("\\[.*?]");
		Matcher matcher = patternCreateRegex.matcher(lines.toString());

		List<String> crates = new ArrayList<>();
		int countOfCrates = 0;
		while (matcher.find()) {
			countOfCrates++;
		}
		int n = countOfCrates / countOfLines;

		Pattern validCratesRegex = Pattern.compile("\\[(#(\\d{" + n + "}|[a-z]{" + n + "}))([A-Za-z0-9\\s]+)(\\1)]");
		Matcher matcher1 = validCratesRegex.matcher(lines.toString());

		int countValidCrates = 0;
		int amountOfFood = 0;
		int amountOfDrink = 0;

		while (matcher1.find()) {
			String crate = matcher1.group();

			String supplyTag = matcher1.group(2);
			String body = matcher1.group(3);

			if (Character.isDigit(supplyTag.charAt(0))) {
				amountOfFood += computeFoodAmount(supplyTag, body);
			} else {
				amountOfDrink += computeDringAmount(supplyTag, body);
			}
			countValidCrates++;

		}
		if (countValidCrates == 0) {
			System.out.println("No supplies found!");
		} else {
			StringBuilder result = new StringBuilder(String.format("Number of supply crates: %d", countValidCrates))
					.append(System.lineSeparator()).append(String.format("Amount of food collected: %d", amountOfFood))
					.append(System.lineSeparator())
					.append(String.format("Amount of drinks collected: %d", amountOfDrink));
			System.out.println(result.toString());
		}

	}

	private static int computeFoodAmount(String supplyTag, String body) {
		int sumOfUniqueCharacters = Arrays.stream(body.split("")).distinct().mapToInt(s -> s.charAt(0)).sum();
		int lenghtOfSupplyTag = supplyTag.length();

		return sumOfUniqueCharacters * lenghtOfSupplyTag;
	}

	private static int computeDringAmount(String supplyTag, String body) {
		int sumOfCharactersBody = Arrays.stream(body.split("")).mapToInt(s -> s.charAt(0)).sum();
		int sumOfCharactersTag = Arrays.stream(supplyTag.split("")).mapToInt(s -> s.charAt(0)).sum();

		return sumOfCharactersBody * sumOfCharactersTag;
	}

}
