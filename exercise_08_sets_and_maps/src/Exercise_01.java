import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise_01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = Integer.parseInt(scanner.nextLine());
		Set<String> names = new LinkedHashSet<>();

		for (int i = 0; i < input; i++) {
			names.add(scanner.nextLine());
		}
		for (String name : names) {
			System.out.println(name);
		}
	}
}
