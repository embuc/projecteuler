package _50to100;

import se.embuc.Task;

import static se.embuc.utils.UtilsKt.getPentagonalNumber;

// Coin partitions - This one is a bit tricky, this final version is inspired by the forum solutions,
// the main idea is to use the pentagonal numbers to calculate the partition function
public class JTask78 implements Task {
	@Override
	public Object solve() {
		final int TARGET_MODULUS = 1_000_000;
		long[] partitions = new long[100_000]; // guessed range
		partitions[0] = 1; // Base case

		int number = 1;
		while (number < partitions.length) {
			long partitionCount = 0;
			int k = 1;
			int pentagonal = getPentagonalNumber(k);

			while (pentagonal <= number) {
				int sign = (k - 1) % 2 == 0 ? 1 : -1;
				partitionCount += sign * partitions[number - pentagonal];
				partitionCount = (partitionCount + TARGET_MODULUS) % TARGET_MODULUS;

				k = getNextK(k);
				pentagonal = getPentagonalNumber(k);
			}

			partitions[number] = partitionCount;
			if (partitionCount == 0) {
				return number;
			}

			number++;
		}
		return -1;
	}

	private static int getNextK(int currentK) {
		return currentK > 0 ? -currentK : (-currentK + 1);
	}

}
