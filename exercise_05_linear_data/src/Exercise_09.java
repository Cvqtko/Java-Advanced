import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Exercise_09 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ArrayDeque<String> queue = new ArrayDeque<>();

		String[] input = scanner.nextLine().split(" ");
		Collections.addAll(queue, input);

		int n = Integer.parseInt(scanner.nextLine());
		scanner.close();
		int cycle = 1;
		while (queue.size() > 1) {
			for (int i = 1; i < n; i++)
				queue.offer(queue.poll());

			if (isPrime(cycle))
				System.out.println("Prime " + queue.peek());
			else
				System.out.println("Removed " + queue.poll());

			cycle++;
		}
		System.out.println("Last is " + queue.poll());
	}

	private static boolean isPrime(int num) {

		if (num == 1) {
			return false;
		}
		for (int i = 2; i <= num / 2; ++i) {
			// condition for nonprime number
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
}
