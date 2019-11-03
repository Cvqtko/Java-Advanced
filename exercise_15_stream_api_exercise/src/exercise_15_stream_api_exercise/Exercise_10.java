package exercise_15_stream_api_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise_10 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String line = reader.readLine();
		List<Person> people = new ArrayList<>();
		while (!"END".equals(line)) {

			String[] tokens = line.split("\\s+");
			String name = tokens[0] + " " + tokens[1];
			int group = Integer.parseInt(tokens[2]);

			Person person = new Person(name, group);
			people.add(person);
			line = reader.readLine();
		}
		Map<Integer, List<Person>> peopleByGroup = people.stream().collect(Collectors.groupingBy(Person::getGroup));

		peopleByGroup.forEach((key, value) -> System.out.printf("%d - %s\n", key,
				String.join(", ", value.stream().map(p -> p.getName()).collect(Collectors.toList()))));
	}
}

class Person {
	String name;
	int group;

	public Person(String name, int group) {
		this.name = name;
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public int getGroup() {
		return group;
	}
}