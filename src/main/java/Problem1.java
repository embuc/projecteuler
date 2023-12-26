import se.embuc.Problem;

import java.util.stream.IntStream;

/* Multiples of 3 and 5 */
public class Problem1 implements Problem {

	public Object solve() {
		return IntStream.range(0, 1000).filter(i -> i % 3 == 0 || i % 5 == 0).sum();
	}
}
