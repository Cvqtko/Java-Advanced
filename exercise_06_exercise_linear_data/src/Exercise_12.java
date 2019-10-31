

import java.util.ArrayDeque;
import java.util.Scanner;

public class Exercise_12 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] parentheses = scanner.nextLine().split("");
		scanner.close();

		ArrayDeque<String> deque = new ArrayDeque<>();
		for (String parenthese : parentheses) {
			deque.add(parenthese);
		}
		boolean correctParentheses = true;
		while (!deque.isEmpty()) {
			String first = deque.removeFirst();
			String last = deque.removeLast();
			if (!checkParentheses(first + last)) {
				correctParentheses = false;
			}
		}
		System.out.println(correctParentheses ? "YES" : "NO");
	}

	public static boolean checkParentheses(String parentheses) {
		System.out.println(parentheses);
		if ("{}".equals(parentheses) || "()".equals(parentheses) || "[]".equals(parentheses))
			return true;
		return false;
	}
}
