package exercise_16_exam_preparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Exercise_02 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		ArrayDeque<Integer> stones = new ArrayDeque<Integer>();
		int[] s = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		for (int i : s) {
			stones.addLast(i);
		}

		int gold = 0;
		String line = reader.readLine();

		while (true) {
			String[] commandArgs = line.split(" ");
			switch (commandArgs[0]) {
			case "Apply":
				gold = applyAcid(stones, gold, commandArgs);
				break;
			case "Air":
				gold = airLeak(stones, gold, commandArgs);
				break;
			default:
				printResult(stones, gold);
				break;
			}
			line = reader.readLine();
		}
	}

	private static int applyAcid(ArrayDeque<Integer> stones, int gold, String[] commandArgs) {
		int acid = Integer.parseInt(commandArgs[2]);
		while (acid-- > 0 && !stones.isEmpty()) {
			int element = stones.pop();
			if (--element <= 0) {
				gold++;
			} else {
				stones.addLast(element);
			}
		}
		return gold;
	}

	private static int airLeak(ArrayDeque<Integer> stones, int gold, String[] commandArgs) {
		int label = Integer.parseInt(commandArgs[2]);
		if (gold <= 0) {
			return gold;
		}
		gold--;
		stones.addLast(label);
		return gold;
	}

	private static void printResult(ArrayDeque<Integer> stones, int gold) {
		while (!stones.isEmpty()) {
			System.out.print(stones.pop() + " ");
		}
		System.out.println("\n" + gold);
	}
}
