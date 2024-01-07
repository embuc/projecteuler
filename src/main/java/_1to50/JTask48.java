package _1to50;

import se.embuc.Task;

import java.math.BigInteger;

public class JTask48 implements Task {
	@Override
	public Object solve() {
		BigInteger sum = BigInteger.ONE;

		for (int x = 2; x <= 1000; x++) {
			sum = sum.add(BigInteger.valueOf(x).pow(x));
		}
		String string = sum.toString();
		return string.substring(string.length() - 10);
	}
}
