import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise_04 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();

		for (int i = 0; i < line.length(); i++) {
			int integerValue = (int) line.codePointAt(i);
			String unicode = String.format("\\u%04x", integerValue);
			System.out.print(unicode);
		}
	}
}
