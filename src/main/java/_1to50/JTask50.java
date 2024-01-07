package _1to50;

import kotlin.Pair;
import se.embuc.Task;

import java.util.List;

import static se.embuc.utils.UtilsKt.getPrimesBelow;

public class JTask50 implements Task {
	@Override
	public Object solve() {
		Pair<List<Integer>, boolean[]> primesBelow = getPrimesBelow(1000000);
		List<Integer> primes = primesBelow.getFirst();
		boolean[] sieve = primesBelow.getSecond();
		int max = 0;
		int maxPrime = 0;
		var maxPrimesToCheck = 0;
		var sum = 0;
		for (int i : primes) {
			sum += i;
			maxPrimesToCheck++;
			if (sum >= 1000000) {
				break;
			}
		}
		for (int i = 0; i < primes.size(); i++) {
			sum = 0;
			int count = 0;
			if (maxPrimesToCheck < count) {
				break;
			}
			maxPrimesToCheck--;
			for (int j = i; j < primes.size(); j++) {
				sum += primes.get(j);
				count++;
				if (sum >= 1000000) {
					break;
				}
				if (count < max) {
					continue;
				}
				if (sieve[sum]) {
					max = count;
					maxPrime = sum;
				}
			}
		}
		return maxPrime;
	}
}
