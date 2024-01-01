package _1to50;

import se.embuc.Task;

//Longest Collatz Sequence
public class JTask14 implements Task {

	private int maxNumber = 1_000_000;
	private long [] cache = new long[maxNumber];

	@Override
	public Object solve() {
		var maxLength = 0L;
		var number = 0L;

		for (int i = 1; i < 1_000_000; i++) {
			var length = findColatzSeqLength(i);
			if (length > maxLength) {
				maxLength = length;
				number = i;
			}
		}
		return number;
	}

	long findColatzSeqLength(long n){
		if (n < maxNumber && cache[(int)n] != 0L) {
			return cache[(int)n];
		}

		var next = (n % 2 == 0L) ? n >> 1 : 3 * n + 1;
		var length = (n != 1L) ? 1 + findColatzSeqLength(next) : 1;
		if (n < maxNumber) {
			cache[(int)n] = length;
		}

		return length;
	}
}
