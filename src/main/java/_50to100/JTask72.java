package _50to100;

import se.embuc.Task;

import static se.embuc.utils.UtilsKt.calculateTotientSum;

// Counting fractions
public class JTask72 implements Task {
	@Override
	public Object solve() {
		return calculateTotientSum(1000000);
		// Bellow: straight forward approach by summing up the totient function for each number from 2 to 1_000_000
		// this is slow-ish, but it works
//		var count = 0L;
//		for (int d = 2; d <= 1000000; d++) {
//			count += phi(d);
//		}
//		return count;
	}
}
