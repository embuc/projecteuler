package _50to100;

import se.embuc.Task;

// Counting fractions in a range
// This is the much faster approach using this clever fact:
// The method makes two recursive calls to itself, each time dividing the range into two smaller ranges. This division is
// based on the property that for any three consecutive fractions A/B, C/D, and E/F in the Stern-Brocot tree (or any
// similar fraction-generating method), the middle fraction C/D can be obtained by adding the numerators and denominators
// of A/B and E/F: C = A + E and D = B + F.
// The left recursive call explores the range between the left limit and the middle fraction, generating a new "middle"
// fraction closer to the left limit.
// The right recursive call explores the range between the middle fraction and the right limit, generating a new "middle"
// fraction closer to the right limit.
public class JTask73 implements Task {

	// Maximum denominator threshold to stop the recursion
	private static final int MAX_DENOMINATOR = 12000;

	private static int countFractionsInRange(int leftNumerator, int leftDenominator,
			int middleNumerator, int middleDenominator,
			int rightNumerator, int rightDenominator,
			int fractionsCount) {

		if (middleDenominator > MAX_DENOMINATOR) {
			return fractionsCount;
		}
		fractionsCount++;

		// Count fractions in the left subrange
		fractionsCount = countFractionsInRange(leftNumerator, leftDenominator,
				leftNumerator + middleNumerator, leftDenominator + middleDenominator,
				middleNumerator, middleDenominator,
				fractionsCount);

		// Count fractions in the right subrange
		fractionsCount = countFractionsInRange(middleNumerator, middleDenominator,
				rightNumerator + middleNumerator, rightDenominator + middleDenominator,
				rightNumerator, rightDenominator,
				fractionsCount);

		return fractionsCount;
	}

	@Override
	public Object solve() {
		// Initial call with the starting fractions 1/3, 2/5, and 1/2
		return countFractionsInRange(1, 3, 2, 5, 1, 2, 0);
	}
}
