import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise_03 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] bannedWords = reader.readLine().split(", ");

		String text = reader.readLine();

		for (String bannedWord : bannedWords) {
		
			text = text.replaceAll(bannedWord, new String(new char[bannedWord.length()]).replace("\0", "*"));
		}
		System.out.println(text);
	}
}
