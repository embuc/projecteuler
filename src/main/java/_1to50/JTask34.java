package _1to50;

import se.embuc.Task;

public class JTask34 implements Task {
	//Precompute factorials

	int[] factorials = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

	@Override
	public Object solve() {
		var sum = 0;
		//n*9! < 10^n Therefore, the upper limit is 10^7, but in reality it is much lower (<50_000)
//		for (i in 3..10_000_000) {
		for (int i = 3; i < 50_000; i++) {
			if (factorialDigitSum(i) == i) {
				sum += i;
			}
		}
		return sum;
	}

	int factorialDigitSum(int x) {
		var sum = 0;
		while (x != 0) {
			sum += factorials[x % 10];
			x /= 10;
		}
		return sum;
	}
}
