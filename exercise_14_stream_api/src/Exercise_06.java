

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;

public class Exercise_06 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Optional<Integer> num = Arrays.stream(reader.readLine().split(" ")).filter(x -> {
			try {
				Integer.parseInt(x);
				return true;
			} catch (Exception e) {
				return false;
			}
		}).map(Integer::parseInt).reduce((x, y) -> x + y);

		if (num.isPresent()) {
			System.out.println(num.get());
		} else {
			System.out.println("No match");
		}

	}
}
