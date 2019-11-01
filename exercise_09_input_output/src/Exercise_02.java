

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exercise_02 {
	public static void main(String[] args) {
		String resourceFolder = "D:\\Java_Softuni_2018\\Java_Advanced\\exercise_09_input_output\\";

		String inputPath = resourceFolder + "input.txt";
		String outputPath = resourceFolder + "output.txt";
		Set<Character> punctuation = new HashSet<>(Arrays.asList(',', '.', '!', '?'));

		try (FileInputStream fis = new FileInputStream(inputPath);
				FileOutputStream fos = new FileOutputStream(outputPath)) {
			int oneByte = fis.read();

			while (oneByte >= 0) {
				if (!punctuation.contains((char) oneByte)) {
					fos.write(oneByte);
				}

				oneByte = fis.read();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}