import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise_05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String line = scanner.nextLine();
		Map<String, String> namesAndNumbers = new HashMap<>();
		while (!"search".equals(line)) {
			namesAndNumbers.put(line.substring(0, line.indexOf("-")), line.substring(line.indexOf("-") + 1));
			line = scanner.nextLine();
		}

		line = scanner.nextLine();
		while (!"stop".equals(line)) {
			String name = line;
			if (namesAndNumbers.containsKey(name)) {
				System.out.printf("%s -> %s\n", name, namesAndNumbers.get(name));
			} else {
				System.out.printf("Contact %s does not exist.\n", name);
			}
			line = scanner.nextLine();
		}
	}
}
