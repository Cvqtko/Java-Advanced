import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Exercise_03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = Integer.parseInt(scanner.nextLine());
		String[] chemicalCompounds;
		Set<String> uniqueCompounds = new TreeSet<>();

		for (int i = 0; i < input; i++) {
			chemicalCompounds = scanner.nextLine().split(" ");
			for (String chemicalCompound : chemicalCompounds) {
				uniqueCompounds.add(chemicalCompound);
			}
		}
		for (String uniqueCompound : uniqueCompounds) {
			System.out.print(uniqueCompound + " ");
		}
	}
}
