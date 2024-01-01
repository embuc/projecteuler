package _1to50;

import se.embuc.Task;

// Reciprocal cycles
public class JTask26 implements Task {
	@Override
	public Object solve() {
		var limit = 1000;
		var max = 0;
		var d = 0;
		for(int i = 1; i < limit; i++) {
			var cycle = getCycle(i);
			if(cycle > max) {
				max = cycle;
				d = i;
			}
		}
		return d;
	}

	int getCycle(int n) {
		boolean[] seenRemainders = new boolean[n + 1];
		int remainder = 1;
		int length = 0;

		while (!seenRemainders[remainder]) {
			seenRemainders[remainder] = true;
			remainder *= 10;
			remainder = remainder % n;
			length++;
		}

		return length;
	}

}
