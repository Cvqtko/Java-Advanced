import java.util.Scanner;

public class Exercise_03 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String[] dimentions = scanner.nextLine().split(", ");

		int rows = Integer.parseInt(dimentions[0]);
		int cols = Integer.parseInt(dimentions[1]);

		int[][] matrix = new int[rows][cols];

		fillMatrix(matrix);
		scanner.close();

		System.out.printf("%d\n%d\n%d\n", matrix.length, matrix[0].length, getMatrixSum(matrix));
	}

	private static int getMatrixSum(int[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				sum += matrix[i][j];
			}
		}
		return sum;
	}

	private static void fillMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			String[] values = scanner.nextLine().split(", ");
			for (int j = 0; j < values.length; j++) {
				matrix[i][j] = Integer.parseInt(values[j]);
			}
		}
	}
}
