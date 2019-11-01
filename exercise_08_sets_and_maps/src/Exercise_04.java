

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercise_04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split("");

		Map<String, Integer> letters = new TreeMap<>();
		for (int i = 0; i < input.length; i++) {
			if (!letters.containsKey(input[i])) {
				letters.put(input[i], 1);
			} else {
				letters.put(input[i], letters.get(input[i]) + 1);
			}
		}
		for (String s : letters.keySet()) {
			System.out.printf("%s: %d time/s\n", s, letters.get(s));
		}
	}
}
