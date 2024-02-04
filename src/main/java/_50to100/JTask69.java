package _50to100;

import se.embuc.Task;

public class JTask69 implements Task {
	@Override
	public Object solve() {
		var n = 1_000_000;
		var max = 0.0;
		var maxN = 0;
		for (int i = 2; i<n; i++) {
			var phi = phi(i);
			var ratio = i / (double)phi;
			if (ratio > max) {
				max = ratio;
				maxN = i;
			}
		}
		return maxN;
	}

	static int phi(int n) {
		double result = n; // Start with n

		// Factorize the number and apply the formula
		for (int p = 2; p * p <= n; ++p) {
			if (n % p == 0) { // Check if p is a prime factor.
				while (n % p == 0) {
					n /= p;
				}
				result *= (1.0 - (1.0 / (double) p));
			}
		}

		// If n has a prime factor greater than sqrt(n) (there can be at most one such prime factor)
		if (n > 1) {
			result *= (1.0 - (1.0 / (double) n));
		}

		return (int) result;
	}
}
