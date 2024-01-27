package _50to100;

import se.embuc.Task;

public class JTask64 implements Task {
	@Override
	public Object solve() {
		boolean[] array = new boolean[10001];
		for (int i = 1; i < 100; i++) {
			var square = i * i;
			array[square] = true;
		}
		var count = 0;
		for (int i = 2; i < 10000; i++) {
			if (array[i]) {
				// skip perfect squares
				continue;
			}
			if(getRecurringContinuousFractionCycle(i) % 2 == 1) {
				count++;
			}
		}

		return count;
	}

	/**
	 * (Mostly)Integer arithmetic, double precision was not enough for bigger numbers.
	 */
	int getRecurringContinuousFractionCycle(int number) {
		int initialRoot = (int) Math.sqrt(number);
		int numerator, denominator, numerator0, denominator0;
		int currentA;
		int periodCount = 0;

		numerator = numerator0 = initialRoot;
		denominator = denominator0 = number - initialRoot * initialRoot;

		do {
			currentA = (initialRoot + numerator) / denominator;
			numerator = currentA * denominator - numerator;
			denominator = (number - numerator * numerator) / denominator;
			periodCount++;
		} while (numerator != numerator0 || denominator != denominator0);

		return periodCount;
	}


}
