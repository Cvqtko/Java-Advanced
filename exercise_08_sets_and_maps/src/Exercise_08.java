
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Exercise_08 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, Integer> types = new HashMap<>();
		types.put("S", 4);
		types.put("H", 3);
		types.put("D", 2);
		types.put("C", 1);

		Map<String, Integer> powers = new HashMap<>();
		powers.put("2", 2);
		powers.put("3", 3);
		powers.put("4", 4);
		powers.put("5", 5);
		powers.put("6", 6);
		powers.put("7", 7);
		powers.put("8", 8);
		powers.put("9", 9);
		powers.put("10", 10);
		powers.put("J", 11);
		powers.put("Q", 12);
		powers.put("K", 13);
		powers.put("A", 14);

		Map<String, Set<String>> players = new LinkedHashMap<>();

		String line;
		while (true) {
			line = scanner.nextLine();
			if ("JOKER".equals(line)) {
				break;
			}
			String[] tokens = line.split(":\\s");
			String name = tokens[0];
			String[] cardTokens = tokens[1].split(",\\s");

			Set<String> cards = new HashSet<>();

			// Collections.addAll(cards, cardTokens);

			for (String cardToken : cardTokens) {
				cards.add(cardToken);
			}

			if (players.containsKey(name)) {
				Set<String> previousCards = players.get(name);
				previousCards.addAll(cards);
				players.put(name, previousCards);
			} else {
				players.put(name, cards);
			}
		}
		for (Map.Entry<String, Set<String>> player : players.entrySet()) {
			int totalCardsStrenght = 0;
			for (String card : player.getValue()) {
				String power = card.substring(0, card.length() - 1);
				String type = String.valueOf(card.charAt(card.length() - 1));

				totalCardsStrenght += computeCardStrenght(power, type, types, powers);

			}
			System.out.printf("%s: %d\n", player.getKey(), totalCardsStrenght);
		}
	}

	private static int computeCardStrenght(String power, String type, Map<String, Integer> types,

			Map<String, Integer> powers) {

		return types.get(type) * powers.get(power);
	}

}
