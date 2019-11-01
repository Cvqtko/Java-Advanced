package exercise_07_sets_and_maps;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise_01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Set<String> cars = new HashSet<>();
		String line = scanner.nextLine();

		while (!"END".equals(line)) {
			String[] carInfo = line.split(", ");
			String direction = carInfo[0];
			String carPlate = carInfo[1];

			if ("IN".equals(direction)) {
				cars.add(carPlate);
			} else {
				cars.remove(carPlate);
			}

			line = scanner.nextLine();
		}
		if (cars.isEmpty()) {
			System.out.println("Parking Lot is Empty");
		} else {
			for (String car : cars) {
				System.out.println(car);
			}
		}
	}
}
