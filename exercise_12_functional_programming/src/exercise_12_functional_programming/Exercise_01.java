package exercise_12_functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Exercise_01 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		List<Integer> numbers = Arrays.stream(reader.readLine().split(", ")).mapToInt(e -> Integer.parseInt(e))
//		.collect(Collectors.toList());

		String[] inputNumbers = reader.readLine().split(", ");
		List<Integer> numbers = new ArrayList<>();
		for (String number : inputNumbers) {
			numbers.add(Integer.parseInt(number));
		}

		numbers.removeIf(e -> e % 2 != 0);

		System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
		numbers.sort((a, b) -> a.compareTo(b));

		System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
	}
}
