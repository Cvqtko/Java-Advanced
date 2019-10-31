

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Exercise_11 {
	static Scanner scanner = new Scanner(System.in);

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		String[][] robotsAndTime = getRobotsAndTime();
		LocalDate localDate = LocalDate.now();
		String scannerTime = scanner.nextLine();
		LocalTime time = LocalTime.parse(getTime(scannerTime));
		ArrayDeque<String> queue = new ArrayDeque<>();

		while (true) {
			String line = scanner.nextLine();
			if ("End".equals(line)) {
				break;
			} else {
				queue.add(line);
			}
		}
		while (!queue.isEmpty()) {
			time = time.plusSeconds(1);
			for (int i = 0; i < robotsAndTime.length; i++) {
				if ("0".equals(robotsAndTime[i][3])) {
					robotTakeElement(robotsAndTime[i], queue.poll(), time);
					robotsAndTime[i][3] = "1";
					break;
				}
			}
			for (int i = 0; i < robotsAndTime.length; i++) {
				if ("1".equals(robotsAndTime[i][3])) {
					robotsAndTime[i][2] = (Integer.parseInt(robotsAndTime[i][2]) - 1) + "";
				}
			}
			for (int i = 0; i < robotsAndTime.length; i++) {
				if ("0".equals(robotsAndTime[i][2])) {
					robotsAndTime[i][2] = robotsAndTime[i][1];
					robotsAndTime[i][3] = "0";
				}
			}
		}

	}

	private static void robotTakeElement(String[] robotsAndTime, String element, LocalTime time) {
		int hour = time.getHour();
		int minute = time.getMinute();
		int second = time.getSecond();
		System.out.printf("%s - %s [%02d:%02d:%02d]\n", robotsAndTime[0], element, hour, minute, second);

	}

	private static String getTime(String time) {
		if (Integer.parseInt(time.substring(0, time.indexOf(":"))) < 10) {
			time = "0" + time;
		}
		return time;
	}

	private static String[][] getRobotsAndTime() {
		String[] firstLine = scanner.nextLine().split(";");
		String[][] robotsAndTime = new String[firstLine.length][4];
		for (int i = 0; i < robotsAndTime.length; i++) {
			String robotName = firstLine[i].substring(0, firstLine[i].indexOf("-"));
			String robotTime = firstLine[i].substring(firstLine[i].indexOf("-") + 1);
			robotsAndTime[i][0] = robotName;
			robotsAndTime[i][1] = robotTime;
			robotsAndTime[i][2] = robotTime;
			robotsAndTime[i][3] = "0";
		}
		return robotsAndTime;
	}

	public static void printMatrix(String[][] robotsAndTime) {
		for (String[] line : robotsAndTime) {
			for (String cell : line) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
	}
}
