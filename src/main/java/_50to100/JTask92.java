package _50to100;

import se.embuc.Task;

public class JTask92 implements Task {

	@Override
	public Object solve() {
		int[] known = new int[10000000];
		known[89] = 89;
		known[1] = 1;


		for (int i = 2; i < 10000000; i++) {
			int current = i;
			while (known[current] == 0) {
				current = getNext(current);
			}

			known[i] = known[current];
		}

		int count = 0;
		for (int n : known) {
			if (n == 89) count++;
		}
		return count;

	}

	private static int getNext(int n) {
		int sum = 0;
		while (n > 0) {
			int digit = n % 10;
			sum += digit * digit;
			n /= 10;
		}
		return sum;
	}
}
