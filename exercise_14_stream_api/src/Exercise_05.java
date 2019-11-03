

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class Exercise_05 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		OptionalDouble minElement = Arrays.stream(reader.readLine().split(" ")).filter(x -> !x.isEmpty())
				.mapToDouble(Double::parseDouble).filter(x -> x % 2 == 0).min();

		if (minElement.isPresent()) {
			System.out.printf("%.2f", minElement.getAsDouble());
		} else {
			System.out.println("No match");
		}
	}
}
