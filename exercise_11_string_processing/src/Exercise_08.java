import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise_08 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String word = reader.readLine();
		StringBuilder pattern = new StringBuilder(reader.readLine());

		while (shakeIt(word, pattern)) {
			word = word.substring(0, word.indexOf(pattern.toString()))
					+ word.substring(word.indexOf(pattern.toString()) + pattern.length(),
							word.lastIndexOf(pattern.toString()))
					+ word.substring(word.lastIndexOf(pattern.toString()) + pattern.length());
			int removeIndex = pattern.length() / 2;
			pattern = pattern.deleteCharAt(removeIndex);
			System.out.println("Shaked it.");
		}
		System.out.println("No shake.");
		System.out.println(word);
	}

	public static boolean shakeIt(String word, StringBuilder pat) {
		String pattern = pat.toString();
		int firstIndex = word.indexOf(pattern);
		int lastIndex = word.lastIndexOf(pattern);

		if (firstIndex != lastIndex) {
			return true;
		}

		return false;
	}
}
