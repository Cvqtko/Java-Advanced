import java.util.Scanner;

public class Exercise_03 {
	public static void main(String[] args) {
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
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				sum += matrix[i][j];
			}
		}
		System.out.printf("%d\n%d\n%d\n", matrix.length, matrix[0].length, sum);
	}
}
