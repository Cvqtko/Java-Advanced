

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise_02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] input = scanner.nextLine().split(" ");

		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();

		for (int i = 0; i < Integer.parseInt(input[0]); i++) {
			set1.add(Integer.parseInt(scanner.nextLine()));
		}
		for (int i = 0; i < Integer.parseInt(input[1]); i++) {
			set2.add(Integer.parseInt(scanner.nextLine()));
		}

		set1.retainAll(set2);

		for (int i : set1) {
			System.out.print(i + " ");
		}
	}
}
