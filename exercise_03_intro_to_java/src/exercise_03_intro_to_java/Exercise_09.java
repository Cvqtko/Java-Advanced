package exercise_03_intro_to_java;

public class Exercise_09 {
	public static void main(String[] args) {

		for (int i = 1; i <= 8; i++) {
			for (int j = 1 + i; j <= 9; j++) {
				for (int k = 1 + j; k <= 10; k++) {
					System.out.printf("%d %d %d%n", i, j, k);
				}
			}
		}
	}
}
