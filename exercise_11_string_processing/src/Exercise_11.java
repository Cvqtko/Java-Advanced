import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_11 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String sb = "";
		String line;
		while (!"END".equals(line = reader.readLine())) {
			sb = sb.concat(line).concat(System.lineSeparator());
		}
		Pattern pattern = Pattern.compile("<a\\s\\S+?>");
		Matcher matcher = pattern.matcher(sb);

		while (matcher.find())
			sb = sb.replaceAll(matcher.group(0), matcher.group(0).replaceAll("<a", "[URL").replaceAll(">", "]"));
		sb = sb.replaceAll("</a>", "[/URL]");
		System.out.println(sb);
	}
}
