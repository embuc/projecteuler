package _1to50;

import se.embuc.Task;

import java.util.ArrayList;
import java.util.List;

import static se.embuc.utils.UtilsKt.gcd;

// Digit cancelling fractions
public class JTask33 implements Task {
	@Override
	public Object solve() {
		List<Long> numerators = new ArrayList<>();
		List<Long> denominators = new ArrayList<>();
		for (long a = 11; a < 99; a++) {
			for (long b = a + 1; b < 100; b++) {
				if (a % 10 == 0 || b % 10 == 0) continue;
				long a1 = a / 10;
				long a2 = a % 10;
				long b1 = b / 10;
				long b2 = b % 10;
				if (a2 == b1 && a * b2 == b * a1) {
					numerators.add(a);
					denominators.add(b);
				}
			}
		}
		long numerator = numerators.stream().reduce(1L, (a, b) -> a * b);
		long denominator = denominators.stream().reduce(1L, (a, b) -> a * b);
		return denominator / gcd(numerator, denominator);
	}

}
