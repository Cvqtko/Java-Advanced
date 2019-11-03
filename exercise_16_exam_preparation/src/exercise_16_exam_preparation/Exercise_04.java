package exercise_16_exam_preparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_04 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Map<String, List<String>> games = new LinkedHashMap<>();
		String line = reader.readLine();
		Pattern pattern = Pattern.compile("([A-Za-z]+) - ([A-Za-z]+) result ([0-9]+):([0-9]+)");

		while (!"Season End".equals(line)) {
			Matcher matcher = pattern.matcher(line);

			matcher.find();
			String homeTeam = matcher.group(1);
			String guestTeam = matcher.group(2);
			String homeTeamResult = matcher.group(3);
			String guestTeamResult = matcher.group(4);

			if (!games.containsKey(homeTeam)) {
				games.put(homeTeam, new ArrayList<>());
			}

			if (!games.containsKey(guestTeam)) {
				games.put(guestTeam, new ArrayList<>());
			}

			String homeGame = String.format(" - %s -> %s:%s", guestTeam, homeTeamResult, guestTeamResult);
			String awayGame = String.format(" - %s -> %s:%s", homeTeam, guestTeamResult, homeTeamResult);

			games.get(homeTeam).add(homeGame);
			games.get(guestTeam).add(awayGame);

			line = reader.readLine();
		}
		printResult(games, reader);
	}

	private static void printResult(Map<String, List<String>> games, BufferedReader reader) throws IOException {
		String[] teams = reader.readLine().split(", ");

		for (String team : teams) {
			games.get(team).stream().sorted(Comparator.comparing(x -> x.split(" -> ")[0]))
					.forEach(match -> System.out.printf("%s%s\n", team, match));
		}

	}

}
