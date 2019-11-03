package exercise_17_exam_preparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Exercise_04 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Map<String, Map<String, Set<String>>> classes = new LinkedHashMap<>();

		String validNameElementRegex = "[A-Z][A-Za-z0-9]+";
		String validDelimeterRegex = "\\s\\|\\s";
		String validLineRegex = String.format("%1$s%2$s%1$s%2$s%1$s", validNameElementRegex, validDelimeterRegex);

		String line = reader.readLine();

		while (!"It's testing time!".equals(line)) {
			if (!line.matches(validLineRegex)) {
				continue;
			}

			String[] tokens = line.split(validDelimeterRegex);

			String clazz = tokens[0];
			String method = tokens[1];
			String unitTest = tokens[2];

			Set<String> unitTests = new LinkedHashSet<>();
			Map<String, Set<String>> methods = new LinkedHashMap<>();

			if (classes.containsKey(clazz)) {
				methods = classes.get(clazz);
			}
			if (methods.containsKey(method)) {
				unitTests = methods.get(method);
			}
			unitTests.add(unitTest);

			methods.put(method, unitTests);
			classes.put(clazz, methods);

			line = reader.readLine();
		}

		StringBuilder result = new StringBuilder();
		classes.entrySet().stream().sorted((clazz1, clazz2) -> {
			int amountUnitTestsClazz1 = clazz1.getValue().values().stream().mapToInt(m -> m.size()).sum();
			int amountUnitTestsClazz2 = clazz2.getValue().values().stream().mapToInt(m -> m.size()).sum();
			int comparatorByAmountOfUnitTests = amountUnitTestsClazz2 - amountUnitTestsClazz1;
			if (comparatorByAmountOfUnitTests != 0) {
				return comparatorByAmountOfUnitTests;
			}

			int amountMethodsClazz1 = clazz1.getValue().size();
			int amountMethodsClazz2 = clazz2.getValue().size();

			int comparatorByAmountOfMethods = amountMethodsClazz2 - amountMethodsClazz1;
			if (comparatorByAmountOfMethods != 0) {
				return comparatorByAmountOfMethods;
			}

			int comparatorByNames = clazz1.getKey().compareTo(clazz2.getKey());
			return comparatorByNames;
		}).forEach(clazz -> {
			result.append(String.format("%s:", clazz.getKey())).append(System.lineSeparator());
			clazz.getValue().entrySet().stream().sorted((method1, method2) -> {
				int amountOfUnitTestsMethod1 = method1.getValue().size();
				int amountOfUnitTestsMethod2 = method2.getValue().size();

				int comparatorByAmountOfTests = amountOfUnitTestsMethod2 - amountOfUnitTestsMethod1;

				if (comparatorByAmountOfTests != 0) {
					return comparatorByAmountOfTests;
				}

				int comparatorBynames = method1.getKey().compareTo(method2.getKey());

				return comparatorBynames;
			}).forEach(method -> {
				result.append(String.format("##%s", method.getKey())).append(System.lineSeparator());

				method.getValue().stream().sorted((unitTest1, unitTest2) -> {
					int comparatorByNamesLenght = unitTest1.length() - unitTest2.length();

					if (comparatorByNamesLenght != 0) {
						return comparatorByNamesLenght;
					}

					int comparatorByNames = unitTest1.compareTo(unitTest2);

					return comparatorByNames;
				}).forEach(unitTest -> {
					result.append(String.format("####%s", unitTest)).append(System.lineSeparator());
				});
			});
		});
		System.out.println(result);
	}
}
