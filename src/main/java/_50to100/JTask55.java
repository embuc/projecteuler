package _50to100;

import se.embuc.Task;

import java.math.BigInteger;

public class JTask55 implements Task {
	@Override
	public Object solve() {
		var count = 0;
		for (int i = 0; i < 10000; i++) {
			if (isLychrel(BigInteger.valueOf(i))) {
				count++;
			}
		}
		return count;
	}

	private boolean isLychrel(BigInteger i) {
		var n = i;
		for (int j = 1; j < 50; j++) {
			n = n.add(new BigInteger((new StringBuilder(n.toString())).reverse().toString()));
			if ((new StringBuilder(n.toString())).reverse().toString().equals(n.toString())) {
				return false;
			}
		}
		return true;
	}
}
