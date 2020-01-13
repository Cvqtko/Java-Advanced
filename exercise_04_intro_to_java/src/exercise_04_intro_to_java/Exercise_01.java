package exercise_04_intro_to_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise_01 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] input = reader.readLine().split("\\s+");

		double sideA = Double.parseDouble(input[0]);
		double sideB = Double.parseDouble(input[1]);

		double rectangleArea = sideA * sideB;

		System.out.println(String.format("%.2f", rectangleArea));
	}

}
