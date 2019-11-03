import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Exercise_09 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] inputNumbers = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt)
				.toArray();
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		for (int number : inputNumbers) {
			numbers.add(number);
		}
		numbers.sort((a, b) -> {
			if (a % 2 != 0 && b % 2 == 0)
				return 1;
			else if (a % 2 == 0 && b % 2 != 0)
				return -1;
			else
				return a.compareTo(b);

		});

		System.out.println(numbers.toString());
	}
}
