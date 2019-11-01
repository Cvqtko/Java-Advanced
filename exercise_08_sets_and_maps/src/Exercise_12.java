import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercise_12 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		Map<String, Integer> materials = new TreeMap<>();
		String[] materialsQuantity;
		String line = "";

		while (!input.isBlank()) {
			line = line + " " + input;
			input = scanner.nextLine();
		}
		materialsQuantity = line.trim().split(" ");
		for (int i = 0; i < materialsQuantity.length - 1; i += 2) {
			String material = materialsQuantity[i + 1].toLowerCase();
			int quantity = Integer.parseInt(materialsQuantity[i]);
			if (materials.containsKey(material)) {
				materials.put(material, materials.get(material) + quantity);
			} else {
				materials.put(material, quantity);
			}
		}

		checkLegendaryItem(materials);
		for (String item : materials.keySet()) {
			System.out.printf("%s: %d\n", item, materials.get(item));

		}
	}

	public static void checkLegendaryItem(Map<String, Integer> materials) {
		int shards = 0;
		int fragments = 0;
		int motes = 0;
		if (materials.containsKey("shards"))
			shards = materials.get("shards");
		if (materials.containsKey("fragments"))
			fragments = materials.get("fragments");
		if (materials.containsKey("motes"))
			motes = materials.get("motes");

		if (shards >= 250) {
			System.out.println("Shadowmourne obtained !");
			shards = shards - 250;
			materials.put("shards", shards);
		}
		if (fragments >= 250) {
			System.out.println("Valanyr obtained !");
			fragments = fragments - 250;
			materials.put("fragments", fragments);
		}
		if (motes >= 250) {
			System.out.println("Dragonwrath obtained !");
			motes = motes - 250;
			materials.put("motes", motes);
		}

	}
}
