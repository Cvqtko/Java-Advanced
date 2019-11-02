package exercise_12_functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise_02 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] inputNumbers = reader.readLine().split(", ");

		int[] numbers = new int[inputNumbers.length];
		int sum = 0;
		for (int i = 0; i < inputNumbers.length; i++) {
			sum += Integer.parseInt(inputNumbers[i]);
			numbers[i] = Integer.parseInt(inputNumbers[i]);
		}
		System.out.println("Count = " + numbers.length);
		System.out.println("Sum = " + sum);
	}
}
