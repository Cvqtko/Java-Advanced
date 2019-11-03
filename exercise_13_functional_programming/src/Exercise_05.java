
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Exercise_05 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] numbers = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();

		String operation = reader.readLine();

		while (!"end".equals(operation)) {
			switch (operation) {
			case "add":
				for (int i = 0; i < numbers.length; i++) {
					numbers[i]++;
				}
				break;
			case "multiply":
				for (int i = 0; i < numbers.length; i++) {
					numbers[i] *= 2;
				}
				break;
			case "subtract":
				for (int i = 0; i < numbers.length; i++) {
					numbers[i]--;
				}
				break;
			case "print":
				Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
				break;
			default:
				break;
			}

			operation = reader.readLine();
		}
		System.out.println();
	}
}
