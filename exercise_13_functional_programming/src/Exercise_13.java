import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Exercise_13 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Integer> gems = new ArrayList<>();
	static HashSet<String> filters = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException {
		getGems();
		getFilters();
		applyFilters();
		System.out.println(gems.toString().replaceAll("[\\[\\]]", ""));
	}

	private static void applyFilters() {
		for (String filter : filters) {
			String[] tokens = filter.split(";");
			switch (tokens[0]) {
			case "Sum Left":
				sumLeft(tokens[1]);
				break;
			case "Sum Right":
				sumRight(tokens[1]);
				break;
			case "Sum Left Right":
				sumLeftRight(tokens[1]);
				break;
			default:
				break;
			}
		}

	}

	private static void sumLeftRight(String sumStr) {
		ArrayList<Integer> removeIndexes = new ArrayList<>();
		int sum = Integer.parseInt(sumStr);

		if (gems.size() == 1) {
			if (gems.get(0) == sum) {
				gems.remove(0);
			}
			return;
		} else if (gems.size() == 0) {
			return;
		}

		if (gems.get(0) + gems.get(1) == sum) {
			removeIndexes.add(0);
		}

		if (gems.get(gems.size() - 1) + gems.get(gems.size() - 2) == sum) {
			removeIndexes.add(gems.size() - 1);
		}

		for (int i = 1; i < gems.size() - 1; i++) {
			if (gems.get(i - 1) + gems.get(i) + gems.get(i + 1) == sum) {
				removeIndexes.add(i);
			}
		}
		for (int i = 0; i < removeIndexes.size(); i++) {
			gems.remove(Integer.parseInt(removeIndexes.get(i).toString()));

		}
	}

	private static void sumRight(String sumStr) {
		ArrayList<Integer> removeIndexes = new ArrayList<>();
		int sum = Integer.parseInt(sumStr);
		if (gems.size() == 0) {
			return;
		}
		if (gems.get(gems.size() - 1) == sum) {
			removeIndexes.add(gems.size() - 1);
		}
		for (int i = 0; i < gems.size() - 1; i++) {
			if (gems.get(i) + gems.get(i + 1) == sum) {
				removeIndexes.add(i);
			}
		}
		for (int i = 0; i < removeIndexes.size(); i++) {
			gems.remove(Integer.parseInt(removeIndexes.get(i).toString()));

		}
	}

	private static void sumLeft(String sumStr) {
		ArrayList<Integer> removeIndexes = new ArrayList<>();
		int sum = Integer.parseInt(sumStr);
		if (gems.size() == 0) {
			return;
		}
		if (gems.get(0) == sum) {
			removeIndexes.add(0);
		}
		for (int i = 1; i < gems.size(); i++) {
			if (gems.get(i - 1) + gems.get(i) == sum) {
				removeIndexes.add(i);
			}
		}
		for (int i = 0; i < removeIndexes.size(); i++) {
			gems.remove(Integer.parseInt(removeIndexes.get(i).toString()));

		}
	}

	private static void getGems() throws IOException {
		String[] inputGems = reader.readLine().split(" ");

		for (int i = 0; i < inputGems.length; i++) {
			gems.add(Integer.parseInt(inputGems[i]));
		}
	}

	private static void getFilters() throws IOException {

		String line = reader.readLine();
		String[] tokens;
		while (!"Forge".equals(line)) {
			tokens = line.split(";");
			line = reader.readLine();
			switch (tokens[0]) {
			case "Exclude":
				filters.add(tokens[1] + ";" + tokens[2]);
				break;
			case "Reverse":
				filters.remove(tokens[1] + ";" + tokens[2]);
				break;
			default:
				break;
			}
		}
	}
}
