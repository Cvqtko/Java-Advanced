

import java.util.ArrayDeque;
import java.util.Scanner;

public class Exercise_14 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfOperations = Integer.parseInt(scanner.nextLine());
		String text = "";
		ArrayDeque<String[]> stack = new ArrayDeque<>();
		for (int i = 0; i < numberOfOperations; i++) {
			String[] tempArr = new String[2];
			String[] opearation = scanner.nextLine().split(" ");
			text = switchCommand(text, stack, tempArr, opearation);
		}
		scanner.close();
	}

	private static String switchCommand(String text, ArrayDeque<String[]> stack, String[] tempArr,
			String[] opearation) {
		switch (Integer.parseInt(opearation[0])) {
		case 1:
			text = text + opearation[1];
			tempArr[0] = "2";
			tempArr[1] = opearation[1].length() - 1 + "";
			stack.add(tempArr);
			break;
		case 2:
			String removed = text.substring(text.length() - Integer.parseInt(opearation[1]));
			text = text.substring(0, text.length() - Integer.parseInt(opearation[1]));
			tempArr[0] = "1";
			tempArr[1] = removed;
			stack.add(tempArr);
			break;
		case 3:
			System.out.println(text.charAt(Integer.parseInt(opearation[1]) - 1));
			break;
		case 4:
			opearation = stack.pop();
			text = switchCommand(text, stack, tempArr, opearation);
			break;
		default:
			break;
		}
		return text;
	}
}
