import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Exercise_10 {
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] inputDivisors = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt)
				.toArray();

		for (int i = 1; i <= N; i++) {
			boolean divisable = true;
			for (int j = 0; j < inputDivisors.length; j++) {
				if (i % inputDivisors[j] != 0) {
					divisable = false;
				}
			}
			if (divisable)
				System.out.print(i + " ");
		}
	}
}
