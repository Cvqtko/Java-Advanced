package exercise_16_exam_preparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise_01 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] coordinates = reader.readLine().split(" ");
		int n = Integer.parseInt(coordinates[0]);
		int m = Integer.parseInt(coordinates[1]);
		int[][] matrix = new int[n][m];

		String line = reader.readLine();
		while (!"Here We Go".equals(line)) {

			int[] tokens = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

			int x1 = tokens[0];
			int y1 = tokens[1];
			int x2 = tokens[2];
			int y2 = tokens[3];

			for (int i = x1; i <= x2; i++) {
				for (int j = y1; j <= y2; j++) {
					try {
						matrix[i][j]++;
					} catch (Exception e) {
						System.out.println("Exception");
					}
				}
			}

			line = reader.readLine();
		}
		for (int[] row : matrix) {
			for (int col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
}
