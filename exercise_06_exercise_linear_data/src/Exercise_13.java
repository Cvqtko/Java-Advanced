

import java.util.Scanner;

public class Exercise_13 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("n = ");
		int n = input.nextInt();
		long result = fib(n + 1);
		System.out.printf("Fib %d = %d%n", n, result);
		input.close();
	}

	public static long fib(int n) {
		if (n <= 2) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}
}
