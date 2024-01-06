package _1to50;

import kotlin.Pair;
import se.embuc.Task;

import java.util.List;

import static se.embuc.utils.UtilsKt.getPrimesBellow;

public class JTask46 implements Task {
	@Override
	public Object solve() {
		var limit = 10_000;
		Pair<List<Integer>, boolean[]> primesBellow = getPrimesBellow(limit);
		var primes = primesBellow.getFirst();
		var sieve = primesBellow.getSecond();
		for (int composite = 33; composite < limit; composite += 2) {
			if (sieve[composite]) continue;
			var foundSquare = false;
			for (int prime : primes) {
				if (prime > composite) break;
				var diff = composite - prime;
				var sqrt = Math.sqrt((diff / 2.0));
				if (sqrt == ((int) sqrt)) {
					foundSquare = true;
					break;
				}
			}
			if (!foundSquare) return composite;
		}
		return -1;
	}
}
