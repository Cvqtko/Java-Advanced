import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercise_14 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int inputNumber = Integer.parseInt(scanner.nextLine());
		String line;

		Map<String, Map<String, Integer[]>> dragons = new LinkedHashMap<>();
		Map<String, Integer[]> dragonDHA = new TreeMap<String, Integer[]>();

		for (int i = 0; i < inputNumber; i++) {
			dragonDHA = new TreeMap<String, Integer[]>();
			line = scanner.nextLine();
			String[] tokens = line.split(" ");
			removeNulls(tokens);

			String dragonType = tokens[0];
			String dragonName = tokens[1];
			String dragonDamage = tokens[2];
			String dragonHealth = tokens[3];
			String dragonArmor = tokens[4];

			Integer[] dha = new Integer[] { Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),
					Integer.parseInt(tokens[4]) };

			if (dragons.containsKey(dragonType)) {
				dragonDHA = dragons.get(dragonType);
				dragonDHA.put(dragonName, dha);
				dragons.put(dragonType, dragonDHA);
			} else {
				dragonDHA.put(dragonName, dha);
				dragons.put(dragonType, dragonDHA);
			}
		}
		printMap(dragons);
	}

	private static void printMap(Map<String, Map<String, Integer[]>> dragons) {
		for (String dragonType : dragons.keySet()) {
			double[] dha = getAverage(dragons.get(dragonType));

			System.out.printf("%s::(%.2f/%.2f/%.2f)\n", dragonType, dha[0], dha[1], dha[2]);

			Map<String, Integer[]> innerMap = dragons.get(dragonType);
			for (String dragon : innerMap.keySet()) {
				System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", dragon, innerMap.get(dragon)[0],
						innerMap.get(dragon)[1], innerMap.get(dragon)[2]);
			}
		}
	}

	private static double[] getAverage(Map<String, Integer[]> dragonDHA) {
		double averageDamage = 0;
		double averageHealth = 0;
		double averageArmor = 0;

		for (String dragon : dragonDHA.keySet()) {
			averageDamage += dragonDHA.get(dragon)[0];
			averageHealth += dragonDHA.get(dragon)[1];
			averageArmor += dragonDHA.get(dragon)[2];
		}

		return new double[] { averageDamage / dragonDHA.size(), averageHealth / dragonDHA.size(),
				averageArmor / dragonDHA.size() };
	}

	public static void removeNulls(String[] tokens) {

		if ("null".equals(tokens[2])) {
			tokens[2] = "45";
		}
		if ("null".equals(tokens[3])) {
			tokens[3] = "250";
		}
		if ("null".equals(tokens[4])) {
			tokens[4] = "10";
		}

	}
}
