
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Exercise_10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Map<String, Long>> countries = new LinkedHashMap<>();
		Map<String, Long> countryPopulation = new HashMap<>();
		String line;
		while (true) {
			line = scanner.nextLine();
			if ("report".equals(line)) {
				break;
			}
			String[] tokens = line.split("\\|");
			String countryName = tokens[1];
			String cityName = tokens[0];
			long population = Long.parseLong(tokens[2]);

			Map<String, Long> cities = new LinkedHashMap<>();
			if (countries.containsKey(countryName)) {
				cities = countries.get(countryName);
			}

			cities.put(cityName, population);
			countries.put(countryName, cities);

			if (!countryPopulation.containsKey(countryName)) {
				countryPopulation.put(countryName, population);
			} else {
				countryPopulation.put(countryName, countryPopulation.get(countryName) + population);
			}

		}
		countryPopulation = sortByValues(countryPopulation);
		for (String country : countryPopulation.keySet()) {
			System.out.printf("%s (total population: %d)\n", country, countryPopulation.get(country));
			Map<String, Long> cityAndPopulation = countries.get(country);
			for (String city : cityAndPopulation.keySet()) {
				System.out.printf("=>%s: %d\n", city, cityAndPopulation.get(city));
			}
		}
	}

	private static HashMap sortByValues(Map<String, Long> map) {
		List list = new LinkedList(map.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
			}
		});

		// Here I am copying the sorted list in HashMap
		// using LinkedHashMap to preserve the insertion order
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}
}
