

import java.util.Scanner;

public class Exercise_04 {

	public static void main(String[] args) {

		int[][] matrix = fillMatrix();
		int bestSum = Integer.MIN_VALUE;
		int rowIndex = 0;
		int colIndex = 0;

		for (int row = 0; row < matrix.length - 2; row++) {

			for (int col = 0; col < matrix[row].length - 2; col++) {
				int sum = 0;
				for (int i = row; i < row + 3; i++) {
					for (int j = col; j < col + 3; j++) {
						sum += matrix[i][j];
					}
				}
				if (sum > bestSum) {
					bestSum = sum;
					rowIndex = row;
					colIndex = col;
				}
			}
		}
		System.out.println("Sum = " + bestSum);
		printMatrix(matrix, rowIndex, colIndex);

	}

	private static void printMatrix(int[][] matrix, int rowIndex, int colIndex) {
		for (int i = rowIndex; i < rowIndex + 3; i++) {
			for (int j = colIndex; j < colIndex + 3; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] fillMatrix() {
		Scanner scanner = new Scanner(System.in);
		String[] dimentions = scanner.nextLine().split(" ");

		int rows = Integer.parseInt(dimentions[0]);
		int cols = Integer.parseInt(dimentions[1]);

		int[][] matrix = new int[rows][cols];

		for (int i = 0; i < matrix.length; i++) {
			String[] values = scanner.nextLine().split(" ");
			for (int j = 0; j < values.length; j++) {
				matrix[i][j] = Integer.parseInt(values[j]);
			}
		}
		scanner.close();
		return matrix;
	}

}
