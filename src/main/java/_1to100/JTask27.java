package _1to100;

import se.embuc.Task;

import static java.lang.Math.sqrt;
import static se.embuc.utils.UtilsKt.isPrime;

// Quadratic Primes
public class JTask27 implements Task {

	private final int maxB = 1000;
	private final boolean[] primes = new boolean[maxB];

	public JTask27() {
		for (int i = 2; i < maxB; i++) {
			primes[i] = true;
		}

		// Sieve of Eratosthenes for prime generation
		for (int i = 2; i < (int) sqrt(maxB); i++) {
			if (primes[i]) {
				for (int j = i * i; j < maxB; j += i) {
					primes[j] = false;
				}
			}
		}
	}
	@Override
	public Object solve() {
		long max = 0L;
		long maxA = 0L;
		long maxB = 0L;

		for (int b = 2; b < this.maxB; b++) {
			if (!primes[b]) continue; // b must be prime
			for (int a = -999; a <= 999; a++) {
				if (a % 2 == 0 && b % 2 == 0) continue; // Ensure a+b+1 is odd
				long n = 0L;
				while (isPrime(n * n + a * n + b)) {
					n++;
				}
				if (n > max) {
					max = n;
					maxA = a;
					maxB = b;
				}
			}
		}
		return maxA * maxB;
	}


}
