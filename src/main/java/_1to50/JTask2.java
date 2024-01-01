package _1to50;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

/* Even Fibonacci numbers */
public class JTask2 implements Task {
	@NotNull
	@Override
	public Object solve() {
		int prev = 1;
		int curr = 2;

		int sum = curr;
		int next = 0;
		int limit = 4_000_000;
		while (next < limit) {
			if (next % 2 == 0) {
				sum += next;
			}
			next = prev + curr;
			prev = curr;
			curr = next;
		}
		return sum;
	}
}
