

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exercise_03 {
	public static void main(String[] args) {
		String resourceFolder = "D:\\Java_Softuni_2018\\Java_Advanced\\exercise_09_input_output\\";

		String inputPath = resourceFolder + "input.txt";
		String outputPath = resourceFolder + "output.txt";

		try (FileInputStream fis = new FileInputStream(inputPath);
				FileOutputStream fos = new FileOutputStream(outputPath)) {
			int oneByte = fis.read();

			int asciiCodeSpace = 32;
			int asciiCodeNewLine = 10;

			while (oneByte >= 0) {
				if (asciiCodeNewLine == oneByte || asciiCodeSpace == oneByte) {
					fos.write(oneByte);
				} else {
					char[] characters = String.valueOf(oneByte).toCharArray();
					for (char character : characters) {
						fos.write(character);
					}
				}
				oneByte = fis.read();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}