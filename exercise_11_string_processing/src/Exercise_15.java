import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_15 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = reader.readLine().split("[\\\\/() ]");

		Pattern pattern = Pattern.compile("^[A-Za-z][A-Za-z\\d_]{2,24}");
		String name1 = "";
		String name2 = "";
		List<String> validUserNames = new ArrayList<>();

		for (String name : tokens) {
			Matcher matcher = pattern.matcher(name);
			if (matcher.find()) {
				validUserNames.add(name);
			}
		}
		if (validUserNames.size() < 2) {
			return;
		}
		int size = 0;
		int maxSize = 0;
		for (int i = 0; i < validUserNames.size() - 1; i++) {
			size = validUserNames.get(i).length() + validUserNames.get(i + 1).length();
			if (size > maxSize) {
				name1 = validUserNames.get(i);
				name2 = validUserNames.get(i + 1);
				maxSize = size;
			}
		}
		System.out.println(name1);
		System.out.println(name2);
	}
}