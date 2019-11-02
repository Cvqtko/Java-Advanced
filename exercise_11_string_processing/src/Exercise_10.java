import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_10 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String line;
		while (!"end".equals(line = reader.readLine())) {
			Pattern pattern = Pattern.compile("(\\+359[\\s]\\d[\\s]\\d{3}[\\s]\\d{4}|\\+359[-]\\d[-]\\d{3}[-]\\d{4})");
			Matcher matcher = pattern.matcher(line);
			if (line.trim().length() == 15) {
				if (matcher.find()) {
					System.out.println(line);
				}
			}
		}

	}
}