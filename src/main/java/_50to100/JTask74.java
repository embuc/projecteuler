package _50to100;

import se.embuc.Task;

public class JTask74 implements Task {

	private static final int[] factorialDigits = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
	private static final int[] chainLengths = new int[3_000_000]; // Stores the length of the factorial chain for each number
	private static int countOfChainsWithLengthSixty = 0;

	private static int sumOfFactorialDigits(int number) {
		if (number == 0) {
			return 0;
		}
		return factorialDigits[number % 10] + sumOfFactorialDigits(number / 10);
	}

	private static int calculateChainLength(int number) {
		if (chainLengths[number] != 0) {
			return chainLengths[number];
		}
		// Initially mark the number as visited to prevent infinite recursion
		chainLengths[number] = 1; // Temporarily set to 1 to mark as visited
		chainLengths[number] = 1 + calculateChainLength(sumOfFactorialDigits(number));
		return chainLengths[number];
	}

	@Override
	public Object solve() {
		// Predefined chain lengths based on the problem's statement
		// These specific values are pre-calculated lengths according to the problem's unique cases.
		chainLengths[169] = 3;
		chainLengths[871] = 2;
		chainLengths[872] = 2;
		chainLengths[40585] = 1;
		chainLengths[145] = 1;
		chainLengths[45361] = 2;
		chainLengths[45362] = 2;

		for (int number = 1; number < 1_000_000; number++) {
			if (calculateChainLength(number) == 60) {
				countOfChainsWithLengthSixty++;
			}
		}

		return countOfChainsWithLengthSixty;
	}
}
