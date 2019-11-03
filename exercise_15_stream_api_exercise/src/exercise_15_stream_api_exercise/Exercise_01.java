package exercise_15_stream_api_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Exercise_01 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> students = new ArrayList<>();
		String line = reader.readLine();
		while (!"END".equals(line)) {
			students.add(line);
			line = reader.readLine();
		}

		students.stream().filter(student -> Integer.parseInt(student.replaceAll("\\D+", "")) == 2)
				.forEach(student -> System.out.println(student.replaceAll("\\d+", "")));
	}
}