package _50to100;

import se.embuc.Task;

import java.math.BigInteger;

import static se.embuc.utils.UtilsKt.factorialBig;

// Combinatoric selections
public class JTask53 implements Task {
	@Override
	public Object solve() {
		var count = 0;
		for (int n = 1; n <= 100; n++) {
			for (int r = 1; r <= n; r++) {
				if (combinations(n, r).compareTo(BigInteger.valueOf(1_000_000)) > 0) {
					count++;
				}
			}
		}
		return count;
	}

	private BigInteger combinations(int n, int r) {
		return factorialBig(n).divide(factorialBig(r).multiply(factorialBig(n - r)));
	}
}
