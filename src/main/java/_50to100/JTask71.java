package _50to100;

import se.embuc.Task;
// Ordered fractions, We need largest fraction in the given set  (D<=1,000,000) which is closest to 3/7
// first we find the target denominator by dividing 1,000,000 by 7 and then multiply the result by 3 and subtract 1 from it
// reason why this works is that largest multiple of 7 less than 1,000,000 is 999,997 and 999,999/7 = 142857 and 142857*3 = 428571
public class JTask71 implements Task {
	@Override
	public Object solve() {
		int i = 1_000_000 / 7;
		int j = 1_000_000 % 7;
		int targetD = 1_000_000 -j;
		int targetN = i * 3 -1;
		return targetN;
	}
}
