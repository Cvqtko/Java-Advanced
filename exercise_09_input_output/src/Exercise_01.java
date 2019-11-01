

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exercise_01 {
	public static void main(String[] args) {
		String resourceFolder = "D:\\Java_Softuni_2018\\Java_Advanced\\exercise_09_input_output\\";

		String path = resourceFolder + "input.txt";

		try (FileInputStream fis = new FileInputStream(path)) {
			int oneByte = fis.read();

			while (oneByte >= 0) {
				System.out.print(Integer.toBinaryString(oneByte));
				oneByte = fis.read();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
