

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise_06 {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String line = scanner.nextLine();
		String rotationAngle = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
		List<String> stackMatrix = initializeStackMatrix();
		char[][] matrix = new char[stackMatrix.size()][findMaxWordLenght(stackMatrix)];
		fillMatrix(matrix, stackMatrix);
		printMatrix(matrix);
		matrix = rotateMatrix(matrix, rotationAngle);
		System.out.println();
		printMatrix(matrix);
		scanner.close();
	}

	private static char[][] rotateMatrix(char[][] matrix, String rotationAngle) {
		char[][] rotatedMatrix = matrix;
		for (int rotations = 0; rotations < Integer.parseInt(rotationAngle) / 90; rotations++) {
			rotatedMatrix = new char[matrix[0].length][matrix.length];
			for (int i = 0; i < rotatedMatrix.length; i++) {
				for (int j = 0; j < rotatedMatrix[i].length; j++) {
					rotatedMatrix[i][j] = matrix[matrix.length - 1 - j][i];
				}
			}
			matrix = rotatedMatrix;
		}

		return rotatedMatrix;

	}

	public static void fillMatrix(char[][] matrix, List<String> stackMatrix) {
		for (int i = 0; i < matrix.length; i++) {
			String word = stackMatrix.remove(0);
			for (int j = 0; j < word.length(); j++) {
				matrix[i][j] = word.charAt(j);
			}
		}
	}

	private static List<String> initializeStackMatrix() {
		int maxCount = 0;
		List<String> matrix = new ArrayList<String>();
		String input = scanner.nextLine();

		while (!"END".equals(input)) {
			maxCount = Math.max(maxCount, input.length());
			matrix.add(input);
			input = scanner.nextLine();
		}

		return matrix;
	}

	private static int findMaxWordLenght(List<String> matrix) {
		int maxWordLenght = 0;
		for (String s : matrix) {
			if (s.length() > maxWordLenght)
				maxWordLenght = s.length();
		}
		return maxWordLenght;
	}

	public static void printMatrix(char[][] matrix) {
		for (char[] line : matrix) {
			for (char cell : line) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
	}

}
