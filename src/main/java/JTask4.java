import se.embuc.Task;

import static se.embuc.utils.UtilsKt.isPalindrome;

/* Largest Palindrome Product */
public class JTask4 implements Task {
	@Override
	public Object solve() {
		int largest = 0;
		for (int i = 999; i > 99; i--) {
			for (int j = 999; j > 99; j--) {
				int product = i * j;
				if (isPalindrome(product) && product > largest) {
					largest = product;
				}
			}
		}

		return null;
	}
}
