package exercise_12_functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Exercise_05 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		HashMap<String, Integer> namesAndAge = new LinkedHashMap<>();
		for (int i = 0; i < 5; i++) {
			String[] tokens = reader.readLine().split(", ");
			namesAndAge.put(tokens[0], Integer.parseInt(tokens[1]));
		}
		String filterCondition = reader.readLine();
		int filterConditionAge = Integer.parseInt(reader.readLine());
		String filterFormat = reader.readLine();

		switch (filterCondition) {
		case "younger":
			namesAndAge.values().removeIf(e -> e >= filterConditionAge);
			break;
		case "older":
			namesAndAge.values().removeIf(e -> e < filterConditionAge);
			break;
		}
		switch (filterFormat) {
		case "name age":
			namesAndAge.forEach((key, value) -> System.out.println(key + " " + value));
			break;
		case "name":
			namesAndAge.forEach((key, value) -> System.out.println(key));
			break;
		case "age":
			namesAndAge.forEach((key, value) -> System.out.println(value));
			break;
		}
	}

}
