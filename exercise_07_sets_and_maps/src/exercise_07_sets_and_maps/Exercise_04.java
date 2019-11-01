package exercise_07_sets_and_maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise_04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] arr = scanner.nextLine().split(" ");
		scanner.close();
		Map<String, Integer> numbers = new HashMap<>();

		for (String num : arr) {
			if (!numbers.containsKey(num)) {
				numbers.put(num, 1);
			} else {
				numbers.put(num, numbers.get(num) + 1);
			}
		}
		for (String key : numbers.keySet()) {
			System.out.printf("%s - %d times\n", key, numbers.get(key));
		}
	}
}
