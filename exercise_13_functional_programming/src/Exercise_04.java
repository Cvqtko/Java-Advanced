
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise_04 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] bounds = reader.readLine().split(" ");
		String evenOrOdd = reader.readLine();

		switch (evenOrOdd) {
		case "even":
			for (int i = Integer.parseInt(bounds[0]); i <= Integer.parseInt(bounds[1]); i++) {
				if (i % 2 == 0)
					System.out.print(i + " ");
			}
			break;
		case "odd":
			for (int i = Integer.parseInt(bounds[0]); i <= Integer.parseInt(bounds[1]); i++) {
				if (i % 2 != 0)
					System.out.print(i + " ");
			}
			break;
		}
	}
}
