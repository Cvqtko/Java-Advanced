

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise_08 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> bounds = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt)
				.sorted((x, y) -> Integer.compare(x, y)).collect(Collectors.toList());

		List<Integer> numbers = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt)
				.collect(Collectors.toList());

		List<Integer> finalNumber = numbers.stream().filter(x -> x >= bounds.get(0) && x <= bounds.get(1))
				.collect(Collectors.toList());

		finalNumber.forEach(x -> System.out.print(x + " "));
	}
}
