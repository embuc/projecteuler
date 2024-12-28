package _50to100;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

public class JTask100 implements Task {

	@NotNull
	@Override
	public Object solve() {
		long b = 15;
		long n = 21;

		while (n < 1000000000000L) {
			long btemp = 3 * b + 2 * n - 2;
			long ntemp = 4 * b + 3 * n - 3;
			b = btemp;
			n = ntemp;
		}

		return b;
	}
}
