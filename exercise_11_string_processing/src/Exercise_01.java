import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_01 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String line = reader.readLine().toLowerCase();
		String patternString = reader.readLine().toLowerCase();

		Pattern pattern = Pattern.compile("(?=(" + patternString + ")).");
		Matcher matcher = pattern.matcher(line);
		int counter = 0;
		while (matcher.find()) {
			counter++;
		}

		System.out.println(counter);
	}

}
