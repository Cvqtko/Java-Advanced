import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_12 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String wholeText = "";
		String line;
		while (!"end".equals(line = reader.readLine())) {
			wholeText = wholeText.concat(line).concat(System.lineSeparator());
		}

		String[] emails = wholeText.split(" ");

		Pattern pattern = Pattern.compile("^[\\dA-Za-z]+[\\dA-Za-z-.]+@[\\w\\d-]+\\.[\\w\\.]+[\\w]+");

		for (String email : emails) {
			Matcher matcher = pattern.matcher(email);
			if (matcher.find())

				System.out.println(matcher.group(0));
		}

	}
}
