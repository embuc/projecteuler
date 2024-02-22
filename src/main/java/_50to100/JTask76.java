package _50to100;

import se.embuc.Task;

// Counting summations
public class JTask76 implements Task {
	@Override
	public Object solve() {
		var n = 100;
		var ways = new int[n + 1];
		ways[0] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = i; j <= n; j++) {
				ways[j] += ways[j - i];
			}
		}
		return ways[n];
	}
}
