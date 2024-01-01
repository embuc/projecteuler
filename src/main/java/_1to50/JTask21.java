package _1to50;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

import static se.embuc.utils.UtilsKt.getDivisorsSum;

// Amicable Numbers
public class JTask21 implements Task {

	// same as for Kotlin version, this is 30% slower than arrays only
	//I'll leave it here for reference and reminder
	//	public Object solve() {
//		Map<Long, Long> dict = new HashMap<>();
//		for (long i = 1; i <= 10000L; i++) {
//			long sumOfDivisors = getDivisorsSum(i);
//			dict.put(i, sumOfDivisors);
//		}
//
//		long sum = 0;
//		for (Map.Entry<Long, Long> entry : dict.entrySet()) {
//			long key = entry.getKey();
//			long value = entry.getValue();
//			Long partner = dict.get(value);
//			if (key != value && partner != null && partner == key) {
//				sum += key;
//			}
//		}
//
//		return sum;
//	}
	@NotNull
	@Override
	public Object solve() {
		int limit = 10000;
		long[] sumOfDivisors = new long[limit + 1];

		// Compute the sum of divisors for each number
		for (int i = 1; i <= limit; i++) {
			sumOfDivisors[i] = getDivisorsSum(i);
		}

		long sum = 0;
		for (int i = 2; i <= limit; i++) {
			int divSum = (int) sumOfDivisors[i];
			if (divSum <= limit && divSum != i && sumOfDivisors[divSum] == i) {
				sum += i;
			}
		}

		return sum;
	}
}
