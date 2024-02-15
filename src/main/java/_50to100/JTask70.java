package _50to100;

import se.embuc.Task;

import static _50to100.JTask69.phi;
import static se.embuc.utils.UtilsKt.isPermutation;

// Totient permutation (pretty slow this one... same as Kotlin version)
public class JTask70 implements Task {
	@Override
	public Object solve() {
		var minN = 0;
		var minRatio = 10_000_000.0;

		for (int i = 2; i<10_000_000;i++) {
			int phi = phi(i);
			if (isPermutation(i, phi)) {
				var ratio = i / (double)phi;
				if (ratio < minRatio) {
					minRatio = ratio;
					minN = i;
				}
			}
		}
		return minN;
	}
}
