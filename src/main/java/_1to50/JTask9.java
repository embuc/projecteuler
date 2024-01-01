package _1to50;

import se.embuc.Task;

public class JTask9 implements Task {

	@Override
	public Object solve() {
		for (int i = 1; i < 1000; i++) {
			for (int j = 1; j < 1000; j++) {
				int k = 1000 - i - j;
				if (i + j + k == 1000 && i * i + j * j == k * k) {
					return i * j * k;
				}
			}
		}
		return -1;
	}
}
