package exercise_17_exam_preparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise_03 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int countOfLines = Integer.parseInt(reader.readLine());

		Deque<Deque<Integer>> sequences = new ArrayDeque<>();
		List<Integer> seismicities = new ArrayList<>();

		while (countOfLines-- > 0) {
			Deque<Integer> sequence = (Deque<Integer>) Arrays.stream(reader.readLine().split("\\s+"))
					.map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
			sequences.add(sequence);
		}
		while (!sequences.isEmpty()) {
			Deque<Integer> currentSequence = sequences.remove();

			int seismicity = currentSequence.remove();
			seismicities.add(seismicity);
			while (!currentSequence.isEmpty()) {
				int wave = currentSequence.peek();
				if (seismicity >= wave) {
					currentSequence.remove();
				} else {
					break;
				}
			}

			if (!currentSequence.isEmpty()) {
				sequences.add(currentSequence);
			}

		}
		System.out.println(seismicities.size());
		System.out.println(seismicities.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}
}
