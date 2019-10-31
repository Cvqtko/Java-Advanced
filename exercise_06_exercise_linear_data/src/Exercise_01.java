
import java.util.Scanner;

public class Exercise_01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] line = scanner.nextLine().split(", ");
		scanner.close();
		int[][] matrix = new int[Integer.parseInt(line[0])][Integer.parseInt(line[0])];
		switch (line[1]) {
		case "A":
			fillMatrixA(matrix);
			break;

		case "B":
			fillMatrixB(matrix);
			break;
		default:
			System.out.println("Invalid input!");
		}
		printMatrix(matrix);
	}

	private static void fillMatrixA(int[][] matrix) {
		int number = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[j][i] = number;
				number++;
			}
		}
	}

	private static void fillMatrixB(int[][] matrix) {
		int row = matrix.length;
		int col = row;
		int sum = 1;
		boolean switchColum = true;
		for (int i = 0; i < row; i++) {
			if (switchColum) {
				for (int j = 0; j < col; j++) {
					matrix[j][i] = sum;
					sum++;
					switchColum = false;
				}
			} else {
				for (int j = col - 1; j >= 0; j--) {
					matrix[j][i] = sum;
					sum++;
					switchColum = true;
				}
			}
		}

	}

	public static void printMatrix(int[][] matrix) {
		for (int[] line : matrix) {
			for (int cell : line) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
	}
}
