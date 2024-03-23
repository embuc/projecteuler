package _50to100;

import se.embuc.Task;

public class JTask85 implements Task {
	@Override
	public Object solve() {
		int area = 1;
		int min = 2000000;
		for (int x = 1; x <= 2000; x++) {
			for (int y = 1; y <= 2000; y++) {
				int count = (((x + 1) * x) * ((y + 1) * y)) / 4;
				if (Math.abs(count - 2000000) < min) {
					min = Math.abs(count - 2000000);
					area = x * y;
				}
			}
		}
		return area;
	}
}
