package exercise_15_stream_api_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Exercise_13 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		Map<String, Map<String, Integer>> companies = new TreeMap<String, Map<String, Integer>>();

		while (n-- > 0) {
			String[] tokens = Arrays.stream(reader.readLine().split("[\\|\\s\\-]+")).filter(e -> !e.equals(""))
					.toArray(String[]::new);

			String companyName = tokens[0];
			int productAmount = Integer.parseInt(tokens[1]);
			String productName = tokens[2];

			Map<String, Integer> products = new LinkedHashMap<String, Integer>();
			if (companies.containsKey(companyName)) {
				products = companies.get(companyName);
				if (products.containsKey(productName)) {
					int newAmount = products.get(productName) + productAmount;
					products.put(productName, newAmount);
				} else {
					products.put(productName, productAmount);
				}

				companies.put(companyName, products);
			} else {
				products.put(productName, productAmount);
				companies.put(companyName, products);
			}
		}
		companies.entrySet().stream().forEach(kv -> {
			StringBuilder company = new StringBuilder(String.format("%s: ", kv.getKey()));
			String products = kv.getValue().entrySet().stream()
					.map(p -> String.format("%s %d", p.getKey(), p.getValue())).collect(Collectors.joining(", "));

			company.append(products).append(System.lineSeparator());

			System.out.print(company);
		});

	}
}
