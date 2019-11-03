import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise_07 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int lenght = Integer.parseInt(reader.readLine());

		String[] names = reader.readLine().split(" ");

		for (int i = 0; i < names.length; i++) {
			if (names[i].length() <= lenght) {
				System.out.println(names[i]);
			}
		}
	}
}
