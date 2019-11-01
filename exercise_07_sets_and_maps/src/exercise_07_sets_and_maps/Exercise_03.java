package exercise_07_sets_and_maps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise_03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Set<Integer> firstPlayer = new LinkedHashSet<>();
		Set<Integer> secondPlayer = new LinkedHashSet<>();

		fillNumbers(scanner, firstPlayer, secondPlayer);

		for (int i = 0; i < 50; i++) {
			if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
				System.out.println(firstPlayer.isEmpty() ? "Second player win!" : "First player win!");
				break;
			}
			int firstPlayerNumber = firstPlayer.iterator().next();
			firstPlayer.remove(firstPlayerNumber);
			int secondPlayerNumber = secondPlayer.iterator().next();
			secondPlayer.remove(secondPlayerNumber);
			if (firstPlayerNumber > secondPlayerNumber) {
				firstPlayer.add(firstPlayerNumber);
				firstPlayer.add(secondPlayerNumber);
			} else if (firstPlayerNumber < secondPlayerNumber) {
				secondPlayer.add(firstPlayerNumber);
				secondPlayer.add(secondPlayerNumber);
			}
		}
		printResult(firstPlayer, secondPlayer);

	}

	private static void printResult(Set<Integer> firstPlayer, Set<Integer> secondPlayer) {
		if (!firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {
			if (firstPlayer.size() > secondPlayer.size()) {
				System.out.println("First player win!");
			} else if (firstPlayer.size() < secondPlayer.size()) {
				System.out.println("Second player win!");
			} else {
				System.out.println("Draw!");
			}

		}
	}

	private static void fillNumbers(Scanner scanner, Set<Integer> firstPlayer,Set<Integer> secondPlayer) {
		String[] firstPlayerNumbers = scanner.nextLine().split(" ");
		String[] secondPlayerNumbers = scanner.nextLine().split(" ");

		for (String firstPlayerNumber : firstPlayerNumbers) {
			firstPlayer.add(Integer.parseInt(firstPlayerNumber));
		}

		for (String secondPlayerNumber : secondPlayerNumbers) {
			secondPlayer.add(Integer.parseInt(secondPlayerNumber));
		}
	}
}
