package exercise_03_intro_to_java;

import java.math.BigDecimal;
import java.util.Scanner;

public class Exercise_04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double kg = scanner.nextDouble();

		BigDecimal marksRate = new BigDecimal(4210500000000.0);
		BigDecimal priceLv = new BigDecimal(1.2*kg);
		
		BigDecimal result = marksRate.multiply(priceLv);
		
		System.out.printf("%.2f marks",result);
	}
}
