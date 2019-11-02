import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Exercise_05 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] words = reader.readLine().split("[ ,\\.\\?\\!]");
		TreeSet<String> set = new TreeSet<>();

		for (int i = 0; i < words.length; i++) {

			if (checkIfPalindrome(words[i])) {
				set.add(words[i]);
			}

		}

		System.out.print("[");
		for (String word : set) {
			System.out.print(word + " ");
		}
		System.out.print("]");

	}

	public static boolean checkIfPalindrome(String word) {
		boolean isPalindrome = true;
		if ("".equals(word) || word == null) {
			return false;
		}
		for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
			if (word.charAt(i) != word.charAt(j))
				isPalindrome = false;
		}
		return isPalindrome;
	}
}
