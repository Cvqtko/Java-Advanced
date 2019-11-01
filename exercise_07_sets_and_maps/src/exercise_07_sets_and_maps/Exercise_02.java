package exercise_07_sets_and_maps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Exercise_02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Set<String> party = new TreeSet<>();
		String line = scanner.nextLine();

		while (!"PARTY".equals(line)) {
			party.add(line);
			line = scanner.nextLine();
		}
		while (!"END".equals(line)) {
			party.remove(line);
			line = scanner.nextLine();
		}
		System.out.println(party.size());
		for (String person : party) {
			System.out.println(person);
		}
	}
}
