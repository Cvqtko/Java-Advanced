import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise_07 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] numbers = reader.readLine().split(" ");
		double magicNumber = 0;
		for (String number : numbers) {
			magicNumber += changeNumbers(number);
		}
		System.out.printf("%.2f",magicNumber);

	}

	public static double changeNumbers(String number) {
		char firstChar = number.charAt(0);
		char lastChar = number.charAt(number.length() - 1);
		double num = Double.parseDouble(number.substring(1, number.length() - 1));

		if (Character.isUpperCase(firstChar)) {
			num /= ((int) firstChar - 64);
		} else {
			num *= ((int) firstChar - 96);
		}

		if (Character.isUpperCase(lastChar)) {
			num -= ((int) lastChar - 64);
		} else {
			num += ((int) lastChar - 96);
		}

		return num;
	}
}
