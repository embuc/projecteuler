package _1to50;

import se.embuc.Task;

import java.math.BigInteger;

// Fibonacci numbers 1000-digit
public class JTask25 implements Task {

	@Override
	public Object solve() {
		BigInteger prev = BigInteger.ONE;
		BigInteger curr = BigInteger.ONE;
		// Define the smallest number with 1000 digits
		BigInteger minLimit = BigInteger.TEN.pow(999); // 10^999
		int count = 2;

		while (curr.compareTo(minLimit) < 0) {
			BigInteger next = prev.add(curr);
			prev = curr;
			curr = next;
			count++;
		}

		return count;
	}
}
