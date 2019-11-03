import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_12 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<String> names = new ArrayList<>();
	static HashSet<String> filters = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException {
		getNames();
		getFilters();
		applyFilters();
		System.out.println(names.toString().replaceAll("[\\[\\]]", ""));
	}

	private static void getNames() throws IOException {
		String[] inputNames = reader.readLine().split(" ");
		for (int i = 0; i < inputNames.length; i++) {
			names.add(inputNames[i]);
		}
	}

	private static void applyFilters() {
		for (String filter : filters) {
			String[] tokens = filter.split(";");
			switch (tokens[0]) {
			case "Starts with":
				removeByPattern("^" + tokens[1]);
				break;
			case "Ends with":
				removeByPattern(tokens[1] + "$");
				break;
			case "Contains":
				removeByPattern("(" + tokens[1] + ")");
				break;
			case "Length":
				removeByLenght(tokens[1]);
				break;
			default:
				break;
			}
		}

	}

	private static void removeByLenght(String lenghtStr) {
		int lenght = Integer.parseInt(lenghtStr);
		ListIterator<String> iter = names.listIterator();
		while (iter.hasNext()) {
			if (iter.next().length() == lenght) {
				iter.remove();
			}
		}
	}

	private static void removeByPattern(String patternString) {
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher;
		ListIterator<String> iter = names.listIterator();
		while (iter.hasNext()) {
			matcher = pattern.matcher(iter.next());
			if (matcher.find()) {
				iter.remove();
			}
		}
	}

	private static void getFilters() throws IOException {

		String line = reader.readLine();
		String[] tokens;
		while (!"Print".equals(line)) {
			tokens = line.split(";");
			line = reader.readLine();
			switch (tokens[0]) {
			case "Add filter":
				filters.add(tokens[1] + ";" + tokens[2]);
				break;
			case "Remove filter":
				filters.remove(tokens[1] + ";" + tokens[2]);
				break;
			default:
				break;
			}
		}

	}
}
