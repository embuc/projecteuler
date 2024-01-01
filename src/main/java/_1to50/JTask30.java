package _1to50;

import se.embuc.Task;

// Digit fifth powers
public class JTask30 implements Task {
	@Override
	public Object solve() {
		var sum = 0;
		for (int i = 2; i < 195_000; i++) {
			var chars = String.valueOf(i).toCharArray();
			var digitSum = 0;
			for (var c : chars) {
				int digit = c - '0';
				digitSum += digit * digit * digit * digit * digit;
			}
			if (digitSum == i) {
				sum += i;
			}
		}
		return sum;
	}
}
