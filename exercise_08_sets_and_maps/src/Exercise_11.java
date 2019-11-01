import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Exercise_11 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int numberOfInputs = Integer.parseInt(scanner.nextLine());
		Map<String, Integer> usersAndTime = new HashMap<>();
		Map<String, Set<String>> usersAndIps = new HashMap<>();

		String line;
		for (int i = 0; i < numberOfInputs; i++) {
			line = scanner.nextLine();
			String[] tokens = line.split(" ");
			String user = tokens[1];
			String ip = tokens[0];
			int time = Integer.parseInt(tokens[2]);

			if (usersAndTime.containsKey(user)) {
				usersAndTime.put(user, usersAndTime.get(user) + time);
			} else {
				usersAndTime.put(user, time);
			}
			if (usersAndIps.containsKey(user)) {
				usersAndIps.get(user).add(ip);
				usersAndIps.put(user, usersAndIps.get(user));
			} else {
				Set<String> ips = new TreeSet<>();
				ips.add(ip);
				usersAndIps.put(user, ips);
			}

		}
		for (String user : usersAndTime.keySet()) {
			System.out.printf("%s: %d [", user, usersAndTime.get(user));
			Object[] ips = usersAndIps.get(user).toArray();
			for (int i = 0; i < ips.length; i++) {
				if (i < ips.length - 1)
					System.out.printf(ips[i] + ", ");
				else
					System.out.printf(ips[i] + "]\n");
			}

		}

	}
}