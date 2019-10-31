import java.util.Scanner;

public class Exercise_04 {
	public static void main(String[] args) {

		int[][] matrix = fillMatrix();
		int bestSum = Integer.MIN_VALUE;
		int rowIndex = 0;
		int colIndex = 0;

		for (int row = 0; row < matrix.length - 1; row++) {

			for (int col = 0; col < matrix[row].length - 1; col++) {
				int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
				if (sum > bestSum) {
					bestSum = sum;
					rowIndex = row;
					colIndex = col;
				}
			}
		}
		for (int i = rowIndex; i < rowIndex + 2; i++) {
			for (int j = colIndex; j < colIndex + 2; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(bestSum);

	}

	public static int[][] fillMatrix() {
		Scanner scanner = new Scanner(System.in);
		String[] dimentions = scanner.nextLine().split(", ");

		int rows = Integer.parseInt(dimentions[0]);
		int cols = Integer.parseInt(dimentions[1]);

		int[][] matrix = new int[rows][cols];

		for (int i = 0; i < matrix.length; i++) {
			String[] values = scanner.nextLine().split(", ");
			for (int j = 0; j < values.length; j++) {
				matrix[i][j] = Integer.parseInt(values[j]);
			}
		}
		scanner.close();
		return matrix;
	}

}
