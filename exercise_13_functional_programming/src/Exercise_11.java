import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_11 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<String> names = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		String[] inputNames = reader.readLine().split(" ");

		for (int i = 0; i < inputNames.length; i++) {
			names.add(inputNames[i]);
		}

		executeCommands();
		if (!names.isEmpty())
			System.out.println(names.toString().replaceAll("[\\[\\]]", "") + " are going to the party!");
		else
			System.out.println("Nobody is going to the party!");

	}

	private static void executeCommands() throws IOException {
		String[] command = reader.readLine().split(" ");
		while (!"Party!".equals(command[0])) {
			switch (command[1]) {
			case "StartsWith":
				startsOrEndWithName(command[0], "^(" + command[2] + ")");
				break;
			case "EndsWith":
				startsOrEndWithName(command[0], "(" + command[2] + ")$");
				break;
			case "Length":
				lenghtName(command[0], command[2]);
				break;
			default:
				break;
			}
			command = reader.readLine().split(" ");
		}
	}

	private static void startsOrEndWithName(String string, String string2) {
		Pattern pattern = Pattern.compile(string2);
		Matcher matcher;
		ArrayList<String> duplicateNames = new ArrayList<>();
		switch (string) {
		case "Remove":
			for (String name : names) {
				matcher = pattern.matcher(name);
				if (matcher.find()) {
					duplicateNames.add(name);
				}
			}
			names.removeAll(duplicateNames);
			break;
		case "Double":

			for (String name : names) {
				duplicateNames.add(name);
				matcher = pattern.matcher(name);
				if (matcher.find()) {
					duplicateNames.add(name);
				}
			}
			names = duplicateNames;
			break;

		}
	}

	private static void lenghtName(String string, String string2) {
		ArrayList<String> duplicateNames = new ArrayList<>();
		switch (string) {
		case "Remove":
			for (String name : names) {
				if (name.length() == Integer.parseInt(string2)) {
					duplicateNames.add(name);
				}
			}
			names.removeAll(duplicateNames);
			break;
		case "Double":
			for (String name : names) {
				duplicateNames.add(name);
				if (name.length() == Integer.parseInt(string2)) {
					duplicateNames.add(name);
				}
			}
			names = duplicateNames;
			break;

		}

	}
}
