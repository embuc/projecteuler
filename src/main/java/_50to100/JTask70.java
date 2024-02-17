package _50to100;

import kotlin.Pair;
import se.embuc.Task;
import se.embuc.utils.PrimesKt;

import java.util.List;

import static se.embuc.utils.UtilsKt.isPermutation;

// Totient permutation (brute force is pretty slow, same as Kotlin version)
// Faster approach:
// p = pi * pj
//-> phi (p) = (pi - 1) * (pj - 1)
public class JTask70 implements Task {
	@Override
	public Object solve() {
		var minN = 0;
		var minRatio = 10_000_000.0;

		Pair<List<Integer>, boolean[]> primes = PrimesKt.getPrimesBelow(5_000_000);
		List<Integer> primeList = primes.getFirst();
		for (int i = 1; i < primeList.size(); i++) {
			for (int j = 0; j < i; j++) {
				int p = primeList.get(i) * primeList.get(j);
				if (p > 10_000_000) {
					break;
				}
				int phi = (primeList.get(i) - 1) * (primeList.get(j) - 1);
				var ratio = (double) p / (double) phi;
				if (ratio < minRatio) {
					if (isPermutation(p, phi)) {
						minRatio = ratio;
						minN = p;
					}
				}
			}
		}
		return minN;
	}
//	@Override
//	public Object solve() {
//		var minN = 0;
//		var minRatio = 10_000_000.0;
//
//		for (int i = 2; i<10_000_000;i++) {
//			int phi = phi(i);
//			var ratio = i / (double)phi;
//			if (ratio < minRatio) {
//				if (isPermutation(i, phi)) {
//					minRatio = ratio;
//					minN = i;
//				}
//			}
//		}
//		return minN;
//	}
}
