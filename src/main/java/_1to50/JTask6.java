package _1to50;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

import java.util.stream.IntStream;

public class JTask6 implements Task {

	@NotNull
	@Override
	public Object solve() {
		return squareOfSum(100) - sumOfSquares(100);
	}

	private long sumOfSquares(int i) {
		return IntStream.rangeClosed(1, i).map(j -> j*j).sum();
	}

	private long squareOfSum(int i) {
		int sum = IntStream.rangeClosed(1, i).sum();
		return (long) sum * sum;
	}
}
