import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_09 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String line;
		while (!"end".equals(line = reader.readLine())) {
			Pattern pattern = Pattern.compile("^[A-Z][a-z]+[\\s?][A-Z][a-z]*\\b");
			Matcher matcher = pattern.matcher(line);

			if (matcher.find()) {
				System.out.println(line);
			}

		}

	}
}