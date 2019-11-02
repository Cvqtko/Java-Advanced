import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise_02 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String longLenghtNumber = reader.readLine();
		String shortLenghtNumber = reader.readLine();

		if (longLenghtNumber.length() < shortLenghtNumber.length()) {
			String temp = longLenghtNumber;
			longLenghtNumber = shortLenghtNumber;
			shortLenghtNumber = temp;
		}
		int overflow = 0;
		StringBuilder sb = new StringBuilder();
		int j = longLenghtNumber.length() - 1;
		for (int i = shortLenghtNumber.length() - 1; i >= 0; i--, j--) {
			int firstDigit = longLenghtNumber.charAt(j) - '0';
			int secondDigit = shortLenghtNumber.charAt(i) - '0';
			int digitSum = firstDigit + secondDigit + overflow;
			overflow = digitSum / 10;
			int digit = digitSum % 10;
			sb.append(digit);
		}
		for (; j >= 0; j--) {
			int firstDigit = longLenghtNumber.charAt(j) - '0';
			int digitSum = firstDigit + overflow;
			overflow = digitSum / 10;
			int digit = digitSum % 10;
			sb.append(digit);
		}
		if (overflow > 0)
			sb.append(overflow);

		System.out.println(sb.reverse().toString());
	}
}
