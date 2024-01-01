package _1to50;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

public class JTask8 implements Task {
	private final String input;

	public JTask8(String input) {
		this.input = input;
	}

	@NotNull
	@Override
	public Object solve() {
		return findLargestProduct(input, 13);
	}

	private Object findLargestProduct(String input, int i) {
		long max = 0;
		for (int j = 0; j < input.length() - i; j++) {
			long product = 1;
			for (int k = 0; k < i; k++) {
				product *= Character.getNumericValue(input.charAt(j + k));
			}
			if (product > max) {
				max = product;
			}
		}
		return max;
	}
}
