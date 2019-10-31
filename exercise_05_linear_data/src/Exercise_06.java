import java.util.ArrayDeque;
import java.util.Scanner;

public class Exercise_06 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());
		scanner.close();
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		while (number > 0) {
			int remainder = number % 2;
			stack.push(remainder);
			number = number / 2;
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}
