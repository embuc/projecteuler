package _1to50;

import se.embuc.Task;

import static se.embuc.utils.UtilsKt.isPermutation;
import static se.embuc.utils.UtilsKt.isPrime;

// Prime permutations
public class JTask49 implements Task {
	@Override
	public Object solve() {

		for (int i = 1000; i<10000;i++) {
			int j = i + 3330;
			int k = j + 3330;
			if(i== 1487) continue;
			if(isPermutation(i,j) && isPermutation(j,k) && isPrime(i) && isPrime(j) && isPrime(k)) {
				return "" + i + j + k;
			}
		}
		return null;
	}

}
