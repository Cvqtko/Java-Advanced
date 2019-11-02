package exercise_12_functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise_04 {
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] numbers = reader.readLine().split(", ");
		System.out.println("Prices with VAT:");
		for (String number : numbers) {
			System.out.printf("%.2f\n", Double.parseDouble(number) + Double.parseDouble(number) * 20 / 100);
		}
	}
}
