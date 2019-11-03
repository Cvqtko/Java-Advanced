package exercise_16_exam_preparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_03 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Map<String, String> decodedWords = new LinkedHashMap<>();

		Pattern pattern = Pattern.compile("([,_])([A-Za-z]+)([0-9])");

		String line = reader.readLine();

		while (!"Ascend".equals(line)) {
			for (Map.Entry<String, String> decodedWord : decodedWords.entrySet()) {
				line = line.replaceAll(decodedWord.getKey(), decodedWord.getValue());
			}

			Matcher matcher = pattern.matcher(line);
			while (matcher.find()) {
				String decoded = decode(matcher.group(1), matcher.group(2), Integer.parseInt(matcher.group(3)));

				decodedWords.putIfAbsent(matcher.group(0), decoded);

				line = line.replaceAll(matcher.group(0), decoded);
				matcher.reset(line);
			}
			System.out.println(line);
			line = reader.readLine();
		}

	}

	private static String decode(String sign, String encodedString, int digit) {
		StringBuilder decoded = new StringBuilder();

		for (int i = 0; i < encodedString.length(); i++) {
			char currentLetter = '\0';
			if (sign.equals(",")) {
				currentLetter = (char) (encodedString.charAt(i) + digit);
			} else {
				currentLetter = (char) (encodedString.charAt(i) - digit);
			}
			decoded.append(currentLetter);
		}
		return decoded.toString();
	}
}
