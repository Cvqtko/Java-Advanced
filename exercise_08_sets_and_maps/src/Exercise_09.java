import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise_09 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		Map<String, Map<String, Integer>> users = new HashMap<>();
		while (!"end".equals(line)) {
			String ip = line.substring(line.indexOf("=") + 1, line.indexOf(" "));
			String user = line.substring(line.indexOf("user=") + 5);
			if (users.containsKey(user)) {
				Map<String, Integer> userIps = users.get(user);
				if (userIps.containsKey(ip)) {
					userIps.put(ip, userIps.get(ip) + 1);
				} else {
					userIps.put(ip, 1);
				}
				users.put(user, userIps);
			} else {
				Map<String, Integer> ips = new LinkedHashMap<>();
				ips.put(ip, 1);
				users.put(user, ips);
			}
			line = scanner.nextLine();
		}
		for (String user : users.keySet()) {
			System.out.println(user + ":");
			Map<String, Integer> userIps = users.get(user);
			for (String ip : userIps.keySet()) {
				System.out.println(ip + " => " + userIps.get(ip));
			}
		}
	}
}
