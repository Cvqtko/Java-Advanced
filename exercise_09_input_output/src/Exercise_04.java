

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise_04 {
	public static void main(String[] args) {
		String resourceFolder = "D:\\Java_Softuni_2018\\Java_Advanced\\exercise_09_input_output\\";

		String inputPath = resourceFolder + "input.txt";
		String outputPath = resourceFolder + "output.txt";

		try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
				PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath));) {

			while (scanner.hasNext()) {
				if (scanner.hasNextInt()) {
					writer.println(scanner.nextInt());
				}

				scanner.next();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}