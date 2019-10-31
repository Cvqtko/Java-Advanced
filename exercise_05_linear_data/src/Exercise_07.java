import java.util.ArrayDeque;
import java.util.Scanner;

public class Exercise_07 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String expression = scanner.nextLine();
		scanner.close();
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int startIndex;
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch == '(')
				stack.push(i);
			else if (ch == ')') {
				startIndex = stack.pop();
				String contents = expression.substring(startIndex, i + 1);
				System.out.println(contents);
			}
		}

	}
}
