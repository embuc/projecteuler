package _1to50;

import se.embuc.Task;

// Champernowne's constant
public class JTask40 implements Task {
	@Override
	public Object solve() {
		var s = new StringBuilder();
		for (int i = 1; i < 200_000; i++) {//there are more decimals using 200_000 natural numbers than needed
			s.append(i);
		}
		var result = 1;
		for (int i = 0; i < 7; i++) {
			result *= s.charAt((int) Math.pow(10, i) - 1) - '0';
		}

		return result;
	}
}
