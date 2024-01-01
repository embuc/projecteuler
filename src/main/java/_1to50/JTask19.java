package _1to50;

import se.embuc.Task;

import java.util.Arrays;
import java.util.List;

// Counting Sundays
public class JTask19 implements  Task {
	private static final List<Integer> monthsInNonLeapYear = Arrays.asList(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
	private static final List<Integer> monthsInLeapYear = Arrays.asList(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
	private static final List<String> days = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

	@Override
	public Object solve() {
		int dayIndex = (monthsInNonLeapYear.stream().mapToInt(Integer::intValue).sum() + 1) % 7; // 1 Jan 1901 was a Tuesday
		int sundayCounter = 0;

		for (int year = 1901; year <= 2000; year++) {
			boolean isLeap = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
			List<Integer> monthsInYear = isLeap ? monthsInLeapYear : monthsInNonLeapYear;
			for (int daysInMonth : monthsInYear) {
				if ("Sunday".equals(days.get(dayIndex))) {
					sundayCounter++;
				}
				dayIndex = (dayIndex + daysInMonth) % 7;
			}
		}
		return sundayCounter;
	}
}
