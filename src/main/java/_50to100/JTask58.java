package _50to100;

import se.embuc.Task;

import static se.embuc.utils.PrimesKt.isPrime;

// Spiral Primes
public class JTask58 implements Task {
	@Override
	public Object solve() {
		int count = 0;
		int i = 1;
		while (true) {
			int odd = 2 * i + 1;
			int biggest = odd * odd;
			for (int j = 1; j <= 3; j++) {
				long next = biggest - (long) j * (odd - 1);
				if (isPrime(next)) {
					count++;
				}
			}
			double diagonalElements = 4 * i + 1;
			int sideLength = odd;
			double ratio = count / diagonalElements;
			if (ratio < 0.1) {
				return sideLength;
			}
			i++;
		}
	}
}
