import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Exercise_06 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] numbers = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();

		int dividor = Integer.parseInt(reader.readLine());

		for (int i = numbers.length - 1; i >= 0; i--) {
			if (numbers[i] % dividor != 0) {
				System.out.print(numbers[i] + " ");
			}
		}
	}
}
