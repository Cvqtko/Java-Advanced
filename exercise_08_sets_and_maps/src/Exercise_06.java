import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise_06 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String line = scanner.nextLine();
		Map<String, String> resourceAndQuantity = new HashMap<>();

		while (!"stop".equals(line)) {
			String quantity = scanner.nextLine();
			resourceAndQuantity.put(line, quantity);
			line = scanner.nextLine();
		}
		for (String resource : resourceAndQuantity.keySet()) {
			System.out.printf("%s -> %s\n", resource, resourceAndQuantity.get(resource));
		}
	}
}
