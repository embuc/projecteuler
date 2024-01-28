package _50to100;

import se.embuc.Task;

import java.math.BigInteger;

import static se.embuc.utils.UtilsKt.solvePell;

// Diophantine equation
public class JTask66 implements Task {

	@Override
	public Object solve() {
		BigInteger maxX = BigInteger.ZERO;
		int maxN = 0;
		for (int n = 2; n <= 1000; n++) {
			if (isPerfectSquare(n)) {
				continue;
			}
			BigInteger x = solvePell(n).getNumerator();
			if (x != null) {
				if (x.compareTo(maxX) > 0) {
					maxX = x;
					maxN = n;
				}
			}
		}
		return maxN;
	}

	private boolean isPerfectSquare(int i) {
		double sqrt = Math.sqrt(i);
		return sqrt == (int) sqrt;
	}
}
