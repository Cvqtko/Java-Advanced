
import java.util.Arrays;
import java.util.Scanner;

public class Exercise_01 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		String[] names = new String[n];
		int[] encryptedNames = new int[n];

		for (int i = 0; i < n; i++) {
			names[i] = input.nextLine();
		}
		input.close();

		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			int currentSum = 0;
			for (int j = 0; j < name.length(); j++) {
				if (checkIfVowel(name.charAt(j))) {
					currentSum += name.charAt(j) * name.length();
				} else {

					currentSum += name.charAt(j) / name.length();
				}
			}
			encryptedNames[i] = currentSum;
		}

		Arrays.sort(encryptedNames);
		System.out.println(Arrays.toString(encryptedNames));
	}

	public static boolean checkIfVowel(char letter) {
		char[] vowels = new char[] { 'a', 'o', 'u', 'e', 'i' };
		for (char ch : vowels) {
			if (ch == Character.toLowerCase(letter)) {
				return true;
			}
		}
		return false;

	}
}
