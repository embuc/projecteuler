package _1to100;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

import static se.embuc.utils.UtilsKt.factorialBig;

public class JTask15 implements Task {
	private final int size;

	public JTask15(int size) {this.size = size;}

	@NotNull
	@Override
	public Object solve() {
		return findPaths(size);
	}

	private Object findPaths(int size) {
		var n = size * 2;
		var k = size;
		return factorialBig(n).divide(factorialBig(k).multiply(factorialBig(n - k)));
	}
}
