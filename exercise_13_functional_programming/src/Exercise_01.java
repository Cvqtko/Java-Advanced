
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise_01 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] names = reader.readLine().split(" ");
		for (String name : names) {
			System.out.println(name);
		}
	}
}
