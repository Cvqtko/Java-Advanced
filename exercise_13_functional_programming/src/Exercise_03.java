
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise_03 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] numbersString = reader.readLine().split(" ");
		int smallest = Integer.MAX_VALUE;
		for (String number : numbersString) {
			if (smallest > Integer.parseInt(number))
				smallest = Integer.parseInt(number);
		}
		System.out.println(smallest);

	}
}
