package _1to50;

import se.embuc.Task;

import static se.embuc.utils.UtilsKt.isPalindrome;

// Double-base palindromes
public class JTask36 implements Task {

	@Override
	public Object solve() {
		int sum = 0;
		for (int i = 1; i < 1_000_000; i+=2) {
			if (isPalindrome(i) && isPalindrome(Integer.toBinaryString(i))) {
				sum += i;
			}
		}
		return sum;
	}
}
