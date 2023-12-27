import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

import static se.embuc.utils.UtilsKt.findNextPrime;

/** Summation of primes */
public class JTask10 implements Task {
	@NotNull
	@Override
	public Object solve() {
		return findPrimeSum(2000000);
	}

	private Object findPrimeSum(int n) {
		long i = 2;
		long sum = i;
		while (i < n) {
			i = findNextPrime(i);
			if(i<n)
				sum+=i;
		}
		return sum;
	}
}
