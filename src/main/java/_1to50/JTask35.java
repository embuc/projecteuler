package _1to50;

import kotlin.Pair;
import se.embuc.Task;

import static se.embuc.utils.PrimesKt.getPrimesSieveBelow;
import static se.embuc.utils.UtilsKt.getIntMagnitude;
//Circular primes
public class JTask35 implements Task {
	@Override
	public Object solve() {
		var primes = getPrimesSieveBelow(1_000_000);
		var count = 2; // 2 and 3 are circular primes
		for (int i = 6;  i<  primes.length; i+=6) { // primes > 3 are of the form 6k +/- 1
			if (primes[i - 1]) {
				count += rotateAndCheck(i - 1, primes);
			}
			if (primes[i + 1]) {
				count += rotateAndCheck(i + 1, primes);
			}
		}
		return count;
	}

	int rotateAndCheck(int i, boolean [] primes){
		var n = i;
		Pair<Integer, Integer> intMagnitude  = getIntMagnitude(i);
		var exp = intMagnitude.getFirst();
		var log = intMagnitude.getSecond();
		while (log-- > 0) {
			n = (10 * n + n / exp) % (10 * exp);
			if (!primes[n]) return 0;
		}

		return 1;
	}
}
