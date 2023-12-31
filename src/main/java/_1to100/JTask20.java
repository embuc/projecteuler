package _1to100;

import se.embuc.Task;

import static se.embuc.utils.UtilsKt.factorialBig;

public class JTask20 implements Task {

	private final int n;

	public JTask20(int n) {
		this.n = n;
	}

	@Override
	public Object solve() {
		return factorialBig(n).toString().chars().map(Character::getNumericValue).sum();
	}
}
