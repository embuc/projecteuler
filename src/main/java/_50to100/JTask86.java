package _50to100;

import se.embuc.Task;

// Cuboid route - this is a better solution provided ßby the forum
public class JTask86 implements Task {

	@Override
	public Object solve() {
		return calculateSolutions();
	}

	/**
	 * Checks if the combination of x and sumOfYAndZ results in an integer after a specific calculation.
	 *
	 * @param x The x value.
	 * @param sumOfYAndZ The sum of y and z values.
	 * @return true if the result is an integer, false otherwise.
	 */
	public static boolean isResultInteger(long x, long sumOfYAndZ) {
		double result = Math.sqrt(x * x + sumOfYAndZ * sumOfYAndZ);
		return result == (long) result;
	}

	public static int calculateSolutions() {
		long solutionsCount = 0;
		int number = 0;

		while (solutionsCount <= 1_000_000) {
			number++;
			for (long sumOfYAndZ = 1; sumOfYAndZ <= number + number; sumOfYAndZ++) {
				if (isResultInteger(number, sumOfYAndZ)) {
					if (sumOfYAndZ > number + 1) {
						solutionsCount += (number + number + 2 - sumOfYAndZ) / 2;
					} else {
						solutionsCount += sumOfYAndZ / 2;
					}
				}
			}
		}
		return number;
	}
}
