package _1to50;

import se.embuc.Task;

import static se.embuc.utils.PrimesKt.getPrimesSieveBelow;
import static se.embuc.utils.UtilsKt.isPanDigit;

// Pandigital prime
// This is a solution by finding all primes within a range and then checking if they are pandigital.
// Reason for range is that 8 and 9 digits (6 and 5 because of same reason too, and it should be larger than 4)
// pandigital numbers are divisible by 3 and thus not prime.
// It's not the most efficient solution, but it's fast enough.
// Kotlin version is using permutation of digits instead, and it's similar in execution speed.
public class JTask41 implements Task {
	@Override
	public Object solve() {
		var primes = getPrimesSieveBelow(7_654_322);
		for (int i = primes.length -1; i > 0; i--) {
			if (primes[i] && isPanDigit(new int []{i})) {
				return i;
			}
		}
		return -1;
	}
}
