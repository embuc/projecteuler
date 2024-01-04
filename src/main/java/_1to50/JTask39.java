package _1to50;

import se.embuc.Task;

public class JTask39 implements Task {
	@Override
	public Object solve() {
		int max = 0;
		int maxP = 0;
		for (int p = 1; p <= 1000; p++) {
			int count = 0;
			for (int a = 1; a < p; a++) {
				for (int b = a; b < p; b++) {
					int c = p - a - b;
					if (a * a + b * b == c * c) {
						count++;
					}
				}
			}
			if (count > max) {
				max = count;
				maxP = p;
			}
		}
		return maxP;
	}
}
