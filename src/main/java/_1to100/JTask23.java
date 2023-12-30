package _1to100;

import se.embuc.Task;

import java.util.stream.IntStream;

import static se.embuc.utils.UtilsKt.getDivisorsSum;

// Non-Abundant Sums
public class JTask23 implements Task {
	@Override
	public Object solve() {
		var limit = 28123;
		var abundantNumbers = IntStream.range(1, limit + 1)
				.filter(i -> getDivisorsSum(i) > i)
				.toArray();
		var abundantSums = new boolean[limit + 2];
		for (var i = 0; i < abundantNumbers.length; i++) {
			for (var j = i; j < abundantNumbers.length; j++) {
				var sum = abundantNumbers[i] + abundantNumbers[j];
				if (sum > limit)//skip-i-dip, since we know that the sum will be greater than the limit for each next
				{break;}
				abundantSums[sum] = true;
			}
		}
		var sum = 0;
		for (var i = 1; i < abundantSums.length - 1; i++) {
			if (!abundantSums[i]) {sum += i;}
		}
		return sum;
	}
}
