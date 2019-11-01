

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Exercise_06 {
	public static void main(String[] args) {
		String resourceFolder = "D:\\Java_Softuni_2018\\Java_Advanced\\exercise_09_input_output\\";

		String inputPathString = resourceFolder + "input.txt";
		String outputPathString = resourceFolder + "output.txt";

		Path inputPath = Paths.get(inputPathString);
		Path outputPath = Paths.get(outputPathString);
		// Use this when reading from console
//try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) {

		try (BufferedReader reader = Files.newBufferedReader(inputPath)) {
			List<String> lines = Files.readAllLines(inputPath);
			Collections.sort(lines);

			Files.write(outputPath, lines);

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}