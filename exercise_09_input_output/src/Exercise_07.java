

import java.io.File;
import java.io.IOException;

public class Exercise_07 {
	public static void main(String[] args) {
		String rootDirectoryPath = "D:\\Java_Softuni_2018\\Java_Advanced\\exercise_09_input_output\\";

		try {
			File rootDir = new File(rootDirectoryPath);
			File[] files = rootDir.listFiles();
			for (File file : files) {
				if (!file.isDirectory()) {
					System.out.printf("%s: [%s bytes]\n", file.getName(), file.length());
				}
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}