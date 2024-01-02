package _1to50;

import se.embuc.Task;

import java.util.HashSet;
import java.util.Set;

import static se.embuc.utils.UtilsKt.isPanDigit;

public class JTask32 implements Task {

	@Override
	public Object solve() {
		return f();
	}

	private static int f() {
		Set<Integer> products = new HashSet<>();
		for (int a = 4; a < 99; a++) {
			if (a % 10 != 0 && a % 11 != 0) {// skip multiples of 10 and 11 e.g. 22, 33, 44, 55... and all the 0s
				for (int b = 123; b < 9876 / a; b++) { // start with first possible permutation of b, 123
					int product = a * b;
					if (product > 9876 || product < 1234) {continue;}
					if (isPanDigit(new int[]{a, b, product})) {
						products.add(product);
					}
				}
			}
		}
		return products.stream().reduce(0, Integer::sum);
	}

}
