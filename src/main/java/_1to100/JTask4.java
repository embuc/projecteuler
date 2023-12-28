package _1to100;

import se.embuc.Task;

import static se.embuc.utils.UtilsKt.isPalindrome;

/* Largest Palindrome Product */
public class JTask4 implements Task {
	@Override
	public Object solve() {
		int largest = 0;
		for (int i = 999; i > 99; i--) {
			// Palindromes are symmetric, so once you find a palindrome for a given i, you don't need to check smaller j
			// values for the same i, because you've already checked these combinations (e.g., 991980 is the same as
			// 980991).
			for (int j = i; j > 99; j--) {
				int product = i * j;
				if (product <= largest) {
					break; //all further products will be smaller
				}
				if (isPalindrome(product)) {
					largest = product;
					break; //no need to check smaller j values for the same i
				}
			}
		}

		return largest;
	}
}
