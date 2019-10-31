

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Exercise_09 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String numberOfOperations = scanner.nextLine();
		ArrayDeque<String> stack = new ArrayDeque<>();
		for (int i = 0; i < Integer.parseInt(numberOfOperations); i++) {
			String[] line = scanner.nextLine().split(" ");
			switch (line[0]) {
			case "1":
				stack.push(line[1]);
				System.out.println("Push " + stack.peek());
				break;

			case "2":
				System.out.println("Pop an element " + stack.pop());
				break;
			case "3":
				System.out.println("Print the maximum element " + Collections.max(stack));
				break;
			default:
				System.out.println("Invalid operation");
			}
		}
		scanner.close();
	}
}
