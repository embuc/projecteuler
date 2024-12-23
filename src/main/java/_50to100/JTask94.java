package _50to100;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;
import se.embuc.utils.UtilsKt;

public class JTask94 implements Task {
	private static final long LIMIT = 1_000_000_000;

	@NotNull
	@Override
	public Object solve() {

		return calculateSum();
	}

	private static long checkConditions(long component, long c) {
		long sum = 0;

		if (component * 2 == c - 1) {
			long p = c * 3 - 1;
			if (p <= LIMIT) {sum += p;}
		}
		if (component * 2 == c + 1) {
			long p = c * 3 + 1;
			if (p <= LIMIT) {sum += p;}
		}

		return sum;
	}

	public static long calculateSum() {
		long sum = 0;
		int bound = (int) Math.sqrt((LIMIT + 1.0) / 3.0);

		for (int s = 1; s <= bound; s += 2) {
			for (int t = s - 2; t >= 1; t -= 2) {
				if (UtilsKt.gcd(s, t) == 1) {
					long a = (long) s * t;
					long b = ((long) s * s - (long) t * t) / 2;
					long c = ((long) s * s + (long) t * t) / 2;

					sum += checkConditions(a, c);
					sum += checkConditions(b, c);
				}
			}
		}

		return sum;
	}
}
