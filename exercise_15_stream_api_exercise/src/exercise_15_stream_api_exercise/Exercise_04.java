package exercise_15_stream_api_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Exercise_04 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> students = new ArrayList<>();
		String line = reader.readLine();
		while (!"END".equals(line)) {
			students.add(line);
			line = reader.readLine();
		}
		students.stream().sorted((st1, st2) -> st2.compareTo(st1)).sorted(
				(st1, st2) -> st1.substring(st1.indexOf(" ") + 1).compareTo(st2.substring(st2.indexOf(" ") + 1)))
				.forEach(System.out::println);
	}
}
