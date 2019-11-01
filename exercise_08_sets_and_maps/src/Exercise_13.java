import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Exercise_13 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Map<String, Integer>> venuesSingers = getInput(scanner);


		for (String venue : venuesSingers.keySet()) {
			Map<String, Integer> singersPrice = sortByValues(venuesSingers.get(venue));
			venuesSingers.put(venue, singersPrice);
		}
		printMap(venuesSingers);
	}

	private static HashMap sortByValues(Map<String, Integer> map) {
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

	private static Map<String, Map<String, Integer>> getInput(Scanner scanner) {
		Map<String, Map<String, Integer>> venuesSingers = new HashMap<>();
		Map<String, Integer> singersPrice = new LinkedHashMap<>();

		String line;
		while (!"End".equals(line = scanner.nextLine())) {

			if (!checkInput(line)) {
				continue;
			}
			String venues = line.replaceAll("[0-9]+", "").trim().substring(line.indexOf("@") + 1).trim();
			String singer = line.substring(0, line.indexOf("@")).trim();
			String ticketPrice = line.substring(line.indexOf(venues) + venues.length()).trim();
			String[] price = ticketPrice.split(" ");
			singersPrice = new HashMap<>();

			if (venuesSingers.containsKey(venues)) {
				singersPrice = venuesSingers.get(venues);
				if (singersPrice.containsKey(singer)) {
					int currentPrice = singersPrice.get(singer)
							+ Integer.parseInt(price[0]) * Integer.parseInt(price[1]);
					singersPrice.put(singer, currentPrice);
					venuesSingers.put(venues, singersPrice);
				} else {
					singersPrice.put(singer, Integer.parseInt(price[0]) * Integer.parseInt(price[1]));
					venuesSingers.put(venues, singersPrice);
				}
			} else {
				singersPrice.put(singer, Integer.parseInt(price[0]) * Integer.parseInt(price[1]));
				venuesSingers.put(venues, singersPrice);
			}

		}

		return venuesSingers;
	}

	private static void printMap(Map<String, Map<String, Integer>> venuesSingers) {
		for (String venue : venuesSingers.keySet()) {
			System.out.println(venue);
			Map<String, Integer> innerMap = venuesSingers.get(venue);
			for (String singers : innerMap.keySet()) {
				System.out.printf("# %s -> %d\n", singers, innerMap.get(singers));
			}
		}
	}

	public static boolean checkInput(String line) {
		String ticketPrice;
		String venues;
		String singer;
		try {

			venues = line.replaceAll("[0-9]+", "").trim().substring(line.indexOf("@") + 1).trim();
			singer = line.substring(0, line.indexOf("@")).trim();
			ticketPrice = line.substring(line.indexOf(venues) + venues.length());

		} catch (StringIndexOutOfBoundsException ex) {
			return false;
		}
		try {
			if (ticketPrice.charAt(0) != ' ') {
				throw new InvalidParameterException();
			}
			ticketPrice = ticketPrice.trim();

			String[] price = ticketPrice.split(" ");
			if (price.length != 2) {
				throw new InvalidParameterException();
			}
			Integer.parseInt(price[0]);
			Integer.parseInt(price[1]);
		} catch (InvalidParameterException ex) {
			return false;
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}
}
