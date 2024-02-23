package _50to100;

import se.embuc.Task;

import static se.embuc.utils.PrimesKt.getPrimesBelow;
// Prime summations
public class JTask77 implements Task {
	@Override
	public Object solve() {
		var primes = getPrimesBelow(100).getFirst();
		var target = 5000;
		var ways = new int[target + 1];
		ways[0] = 1;
		for (int prime : primes) {
			for (int i = prime; i < 100; i++) {
				ways[i] += ways[i - prime];
			}
		}
		for (int i = 0; i < 100; i++) {
			if (ways[i] > 5000) {
				return i;
			}
		}
		return 0;
	}
}
