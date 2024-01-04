package _1to50;

import kotlin.Pair;
import se.embuc.Task;

import static se.embuc.utils.UtilsKt.getIntMagnitude;
import static se.embuc.utils.UtilsKt.getPrimesSieveBelow;

//Truncatable primes
public class JTask37 implements Task {

	@Override
	public Object solve() {
		var sum = 0;
		var sieve = getPrimesSieveBelow(1_000_000);
		for (int i = 18; i < sieve.length; i += 6) {
			if (sieve[i + 1]) {
				if (isTruncatablePrime(i + 1, sieve)) {
					sum += i + 1;
				}
			}
			if (sieve[i - 1]) {
				if (isTruncatablePrime(i - 1, sieve)) {
					sum += i - 1;
				}
			}
		}
		return sum;
	}

	boolean isTruncatablePrime(int i, boolean[] sieve) {
		var n = i;
		while (n > 0) {
			if (!sieve[n]) {
				return false;
			}
			n /= 10;
		}
		Pair<Integer, Integer> intMagnitude = getIntMagnitude(i);
		var exp = intMagnitude.getFirst();
		var log = intMagnitude.getSecond();

		n = i;
		while (log >= 0) {
			if (!sieve[n]) {
				return false;
			}
			n %= exp;
			exp /= 10;
			log--;
		}
		return true;
	}
}
