import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Exercise_08 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] numbers = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();

		int smallestNumber = Integer.MAX_VALUE;
		int smallestPosition = 0;

		for (int i = 0; i < numbers.length; i++) {
			if (smallestNumber >= numbers[i]) {
				smallestNumber = numbers[i];
				smallestPosition = i;
			}
		}
		System.out.println(smallestPosition);
	}
}
