package _1to50;

import se.embuc.Task;

import static se.embuc.utils.UtilsKt.primeFactorsCount;

// Distinct primes factors
public class JTask47 implements Task {
	@Override
	public Object solve() {
		var result = 0;
		for (int i = 2*3*5*7; ; i++) {
			var found = true;
			for (int j = 0; j < 4; j++) {
				if (primeFactorsCount(i + j) != 4) {
					i += j;
					found = false;
					break;
				}
			}
			if (found) {
				result = i;
				break;
			}
		}
		return result;
	}

}
