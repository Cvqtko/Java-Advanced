import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Exercise_07 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String line = scanner.nextLine();
		Map<String, String> nameEmails = new HashMap<>();

		while (!"stop".equals(line)) {
			String email = scanner.nextLine();
			nameEmails.put(line, email);
			line = scanner.nextLine();
		}

		Iterator iter = nameEmails.entrySet().iterator();

		while (iter.hasNext()) {
			Map.Entry pair = (Map.Entry) iter.next();
			String email = (String) pair.getValue();
			if ("us".equals(email.substring(email.indexOf(".") + 1))
					|| "uk".equals(email.substring(email.indexOf(".") + 1))
					|| "com".equals(email.substring(email.indexOf(".") + 1))) {
				iter.remove();
			} else {
				System.out.printf("%s -> %s\n", pair.getKey(), pair.getValue());
			}
		}

	}
}
