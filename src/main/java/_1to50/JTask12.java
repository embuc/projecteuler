package _1to50;

import se.embuc.Task;

import static se.embuc.utils.UtilsKt.getDivisorsCount;
import static se.embuc.utils.UtilsKt.getTriangleNumber;

// Highly Divisible Triangular Number
public class JTask12 implements Task {

	@Override
	public Object solve() {
		long target = 500;
		long i = 0;
		while (true) {
			long divisorCount = 0;
			if (i % 2 == 0L) {
				divisorCount = (long) getDivisorsCount(i / 2) * getDivisorsCount(i + 1);
			} else {
				divisorCount = (long) getDivisorsCount(i) * getDivisorsCount((i + 1) / 2);
			}
			if (divisorCount > target) {
				return getTriangleNumber(i);
			}
			i++;
		}
	}

}
