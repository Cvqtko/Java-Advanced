import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Exercise_06 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] words = reader.readLine().split(" ");

		System.out.print(checkIfExchangeable(words[0], words[1]));

	}

	private static boolean checkIfExchangeable(String string1, String string2) {
		boolean isExchangeable = true;
		if (string1.length() < string2.length()) {
			String temp = string1;
			string1 = string2;
			string2 = temp;
		}
		Map<Character, Character> magicMap = new HashMap<>();

		int j = 0;
		for (int i = 0; i < string2.length(); i++, j++) {
			if (!magicMap.containsKey(string1.charAt(i))) {
				magicMap.put(string1.charAt(i), string2.charAt(i));
			} else {
				char ch = magicMap.get(string1.charAt(i));
				if (ch != string2.charAt(i)) {
					isExchangeable = false;
				}
			}
		}
		for (; j < string1.length(); j++) {
			if (!magicMap.containsKey(string1.charAt(j)))
				isExchangeable = false;
		}
		return isExchangeable;
	}
}
