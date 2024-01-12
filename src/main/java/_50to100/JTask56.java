package _50to100;

import se.embuc.Task;

import java.math.BigInteger;

// Powerful digit sum
public class JTask56 implements Task {
	@Override
	public Object solve() {
		int max = 0;
		for (int a = 1; a < 100; a++) {
			for (int b = 1; b < 100; b++) {
				int sum = new BigInteger(String.valueOf(a)).pow(b).toString().chars().map(c -> c - '0').sum();
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}
}
