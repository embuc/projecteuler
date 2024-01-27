package _50to100;

import se.embuc.Task;

import java.math.BigInteger;

// Powerful digit counts
public class JTask63 implements Task {
	@Override
	public Object solve() {
		int count = 1; // Account for 1^1 case

		for (int base = 1; base <= 9; base++) {
			for (int exp = 1; exp <= 100; exp++) {
				BigInteger result = BigInteger.valueOf(base).pow(exp);
				BigInteger upperLimit = BigInteger.TEN.pow(exp);

				if (result.compareTo(BigInteger.TEN.pow(exp - 1)) > 0 && result.compareTo(upperLimit) < 0) {
					count++;
				} else if (result.compareTo(upperLimit) >= 0) {
					break;
				}
			}
		}

		return count;
	}
}
