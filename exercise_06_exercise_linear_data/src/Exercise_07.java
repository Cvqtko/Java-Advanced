

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise_07 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] array = scanner.nextLine().split("\\s+");
		ArrayDeque<String> deque = new ArrayDeque<>();
		for (int i = 0; i < array.length; i++) {
			deque.push(array[i]);
		}
		while (!deque.isEmpty()) {
			System.out.print(deque.pop() + " ");
		}
		scanner.close();
	}
}
