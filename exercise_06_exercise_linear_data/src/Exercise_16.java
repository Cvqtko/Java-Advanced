
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise_16 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numberOfPlants = Integer.parseInt(input.nextLine());
		String[] plantsArr = input.nextLine().split(" ");
		input.close();

		ArrayList<Integer> plants = new ArrayList<>();
		for (int i = 0; i < numberOfPlants; i++) {
			plants.add(Integer.parseInt(plantsArr[i]));
		}
		boolean plantDied = true;
		int day = 0;

		ArrayList<Integer> deadPlants = new ArrayList<>();

		while (plantDied) {
			deadPlants = new ArrayList<>();
			day++;
			plantDied = false;
			for (int i = 1; i < plants.size(); i++) {
				if (plants.get(i - 1) < plants.get(i)) {
					plantDied = true;
					deadPlants.add(i);
				}
			}
			for (int i = 0; i < deadPlants.size(); i++) {
				plants.set(deadPlants.get(i), Integer.MAX_VALUE);
			}
			plants.removeAll(Arrays.asList(Integer.MAX_VALUE));

		}
		System.out.println(--day);
	}
}
