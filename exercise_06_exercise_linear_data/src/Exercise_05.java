

import java.util.Scanner;

public class Exercise_05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] rowsCols = scanner.nextLine().split("\\s+");
		int rows = Integer.parseInt(rowsCols[0]);
		int cols = Integer.parseInt(rowsCols[1]);
		String[][] matrix = new String[rows][cols];

		for (int i = 0; i < rows; i++) {
			String[] line = scanner.nextLine().split("\\s+");
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = line[j];
			}
		}
		String line;
		while (true) {
			if ("END".equals(line = scanner.nextLine())) {
				break;
			}

			String[] tokens = line.split("\\s+");

			if (!"swap".equals(tokens[0]) || tokens.length != 5) {
				System.out.println("Invalid input!");
				continue;
			}
			int row1 = Integer.parseInt(tokens[1]);
			int col1 = Integer.parseInt(tokens[2]);
			int row2 = Integer.parseInt(tokens[3]);
			int col2 = Integer.parseInt(tokens[4]);
			try {
				swap(row1, col1, row2, col2, matrix);
				printMatrix(matrix);
			} catch (IndexOutOfBoundsException | NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		}
		scanner.close();
	}

	public static void printMatrix(String[][] matrix) {
		for (String[] line : matrix) {
			for (String cell : line) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
	}

	private static void swap(int row1, int col1, int row2, int col2, String[][] matrix) {
		String firstCell = matrix[row1][col1];
		String secondCell = matrix[row2][col2];

		matrix[row1][col1] = secondCell;
		matrix[row2][col2] = firstCell;
	}
}
