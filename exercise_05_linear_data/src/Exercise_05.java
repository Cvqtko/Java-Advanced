import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Exercise_05 {
	public static void main(String[] args) {
		// 2 + 5 + 10 - 2 - 1
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split("\\s+");
		scanner.close();
		ArrayDeque<String> queue = new ArrayDeque<String>();

		Collections.addAll(queue, input);

		while (queue.size() > 1) {
			int firstNum = Integer.parseInt(queue.poll());
			String op = queue.poll();
			int secondNum = Integer.parseInt(queue.poll());

			if (op.equals("+")) {
				queue.addFirst(firstNum + secondNum + "");
			} else {
				queue.addFirst(firstNum - secondNum + "");
			}
		}
		System.out.println(queue.peek());
	}
}
