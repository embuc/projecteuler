package _50to100;

import se.embuc.Task;

import static se.embuc.utils.UtilsKt.phi;

// Counting fractions
public class JTask72 implements Task {
	@Override
	public Object solve() {
		var count = 0L;
		for (int d = 2; d <= 1000000; d++) {
			count += phi(d);
		}
		return count;
	}
}
