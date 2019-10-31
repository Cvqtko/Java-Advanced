

import java.util.Scanner;

public class Exercise_03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] line = scanner.nextLine().split("\\s+");
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(line[j]);
			}
		}
		scanner.close();

		int firstDiagonalSum = 0;
		int secondDiagonalSum = 0;

		for (int i = 0; i < matrix.length; i++) {
			firstDiagonalSum += matrix[i][i];
			secondDiagonalSum += matrix[i][matrix.length - 1 - i];
		}
		System.out.println(Math.abs(firstDiagonalSum - secondDiagonalSum));
	}


}
