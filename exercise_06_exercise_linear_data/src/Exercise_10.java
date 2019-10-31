

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Exercise_10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] firstLine = scanner.nextLine().split("\\s+");
		int elementToPush = Integer.parseInt(firstLine[0]);
		int elementToPop = Integer.parseInt(firstLine[1]);
		int searchedElement = Integer.parseInt(firstLine[2]);

		String[] secondLine = scanner.nextLine().split("\\s+");

		ArrayDeque<Integer> queue = new ArrayDeque<>();

		for (int i = 0; i < elementToPush; i++) {

			queue.add(Integer.parseInt(secondLine[i]));
		}
		for (int i = 0; i < elementToPop; i++) {
			if (queue.isEmpty()) {
				break;
			}
			queue.poll();
		}
		if (queue.isEmpty()) {
			System.err.println(0);
		} else if (queue.contains(searchedElement)) {
			System.out.println("true");
		} else {
			System.out.println(Collections.min(queue));
		}

		scanner.close();
	}

}
