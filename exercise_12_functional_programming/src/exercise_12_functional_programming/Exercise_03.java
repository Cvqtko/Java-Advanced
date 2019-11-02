package exercise_12_functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise_03 {
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] words = reader.readLine().split("[ \\.,]");
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			if (!"".equals(word)) {
				if (Character.isUpperCase(word.charAt(0))) {
					count++;
					sb.append(word + "\n");
				}
			}
		}
		System.out.println(count + "\n" + sb);

	}
}
