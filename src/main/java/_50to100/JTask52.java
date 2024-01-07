package _50to100;

import se.embuc.Task;

import java.util.stream.IntStream;

import static se.embuc.utils.UtilsKt.isPermutation;

// Permuted multiples
public class JTask52 implements Task {
	@Override
	public Object solve() {
		var number = 123456;
		while (true) {
			int finalNumber = number;
			var products = IntStream.range(2, 7).map(n -> n * finalNumber).filter(
					n -> isPermutation(n, finalNumber)).toArray();

			if (products.length == 5) {
				return number;
			}
			number++;
		}
	}
}
