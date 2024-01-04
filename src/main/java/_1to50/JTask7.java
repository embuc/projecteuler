package _1to50;

import se.embuc.Task;
import se.embuc.utils.UtilsKt;

// 10001st Prime
public class JTask7 implements Task {
	@Override
	public Object solve() {
		return findNthPrime(10001);
	}


	private long findNthPrime(int nth) {
		var limit = 2 * nth * 6 + 1;
		var primes = UtilsKt.getPrimesSieveBelow(limit);

		var count = 2;
		for (int i = 6; i < primes.length; i += 6) {
			var prime = 0;
			if (primes[i + 1]) {
				count++;
				prime = i + 1;
			}
			if (primes[i - 1]) {
				count++;
				prime = i + 1;
			}

			if (count == nth) {return prime;}
		}
		return -1;
	}

	// reads better then using sieve but slower
//	private long findNthPrime(int i) {
//		int count = 1;
//		long prime = 2;
//		while (count < i) {
//			prime = findNextPrime(prime);
//			count++;
//		}
//		return prime;
//	}
}
