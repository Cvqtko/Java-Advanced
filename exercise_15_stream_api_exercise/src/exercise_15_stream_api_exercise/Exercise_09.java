package exercise_15_stream_api_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_09 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> students = new ArrayList<>();
		String line = reader.readLine();
		while (!"END".equals(line)) {
			students.add(line);
			line = reader.readLine();
		}
		students.stream().filter(student -> {
			String[] studentInfo = student.split(" ");
			Pattern pattern = Pattern.compile("14$|15$");
			Matcher matcher = pattern.matcher(studentInfo[0]);
			return matcher.find();

		}).forEach(student -> System.out.println(student.replaceAll("^\\d+", "").trim()));
	}
}
