package _50to100;

import se.embuc.Task;

import static se.embuc.utils.UtilsKt.gcd;

// Singular integer right triangles - check the Kotlin version for explanation
public class JTask75 implements Task {
	@Override
	public Object solve() {
		return generatePythagoreanTriples(1_500_000);
	}

	public static int generatePythagoreanTriples(int limit) {
		int[] arr = new int[limit]; // Track how many triangles we can form with a given perimeter
		for (int m = 2; m <= Math.sqrt(limit); m++) {
			for (int n = 1; n < m; n++) {
				if ((m - n) % 2 == 1 && gcd(m, n) == 1) {
					int k = 1; // Initialize multiplier
					while (true) {
						int a = k * (m * m - n * n);
						int b = k * (2 * m * n);
						int c = k * (m * m + n * n);
						if (a + b + c >= limit) break; // Stop if the sum exceeds the limit
						int L = a + b + c;
						if (L < limit) { // Ensure we don't exceed array bounds
							arr[L]++;
						}
						k++; // Increment multiplier to generate next set of triples
					}
				}
			}
		}
		int count = 0;
		for (int i = 0; i < limit; i++) {
			if (arr[i] == 1) {
				count++;
			}
		}
		return count;
	}
}
