package _1to50;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

import static se.embuc.utils.UtilsKt.findNextPrime;

public class JTask7 implements Task {
	@NotNull
	@Override
	public Object solve() {
		return findNthPrime(10001);
	}

	private long findNthPrime(int i) {
		int count = 1;
		long prime = 2;
		while (count < i) {
			prime = findNextPrime(prime);
			count++;
		}
		return prime;
	}
}
