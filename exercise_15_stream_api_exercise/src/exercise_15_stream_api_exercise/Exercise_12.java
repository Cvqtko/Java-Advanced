package exercise_15_stream_api_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_12 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		int small = 0;
		int medium = 0;
		int large = 0;

		while (!"".equals(line)) {
			large += findMatches(line, "(>>>----->>)(\\s|\\w|\\Z)");
			medium += findMatches(line, "(>>----->)(\\s|\\w|\\Z)");
			small += findMatches(line, "[\\^\\>](>----->)(\\s|\\w|\\Z)");
			line = reader.readLine();
		}

		String number = small + "" + medium + "" + large;
		String binary = Integer.toBinaryString(Integer.parseInt(number));
		StringBuilder reversed = new StringBuilder(binary);
		binary = binary.concat(reversed.reverse().toString());

		int decryptedMessage = Integer.parseInt(binary, 2);
		System.out.print(decryptedMessage);
	}

	private static int findMatches(String line, String inputPattern) {
		int matchesFound = 0;
		Pattern pattern = Pattern.compile(inputPattern);
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			matchesFound++;
		}
		return matchesFound;
	}

}
