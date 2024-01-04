package _1to50;

import se.embuc.Task;

public class JTask39 implements Task {
	@Override
	public Object solve() {
		var maxSolutions = 0;
		var perimeter = 0;

		for (int p = 3; p < 1000; p++) {
			var solutions = 0;
			for (int a = 2; a < (p / 3); a++) {
				if ((p * p - 2 * p * a) % (2 * p - 2 * a) == 0) {
					solutions += 1;
				}
			}
			if (solutions > maxSolutions) {
				maxSolutions = solutions;
				perimeter = p;
			}
		}
		return perimeter;
	}
}
