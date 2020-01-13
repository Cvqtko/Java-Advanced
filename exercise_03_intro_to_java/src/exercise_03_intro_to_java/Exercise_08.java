package exercise_03_intro_to_java;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise_08 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int temp = n;
		int m = scanner.nextInt();

		BigInteger result = BigInteger.ONE;

		do {
			result = result.multiply(BigInteger.valueOf(temp));
			temp++;
		} while (temp <= m);

		System.out.printf("product[%d..%d] = %s", n, m, result);
	}

}
