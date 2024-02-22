package se.embuc._50to100

import se.embuc.Task

// Counting fractions in a range
class Task73:Task {

	private fun countFractions(leftNumerator: Int, leftDenominator: Int, middleNumerator: Int, middleDenominator: Int,
							   rightNumerator: Int, rightDenominator: Int, currentCount: Int): Int {
		if (middleDenominator > 12000) return currentCount
		var count = currentCount + 1
		count = countFractions(leftNumerator, leftDenominator, leftNumerator + middleNumerator,
			leftDenominator + middleDenominator, middleNumerator, middleDenominator, count)
		count = countFractions(middleNumerator, middleDenominator, rightNumerator + middleNumerator,
			rightDenominator + middleDenominator, rightNumerator, rightDenominator, count)
		return count
	}

	override fun solve(): Int = countFractions(1, 3, 2, 5, 1, 2, 0)

	// This is the original solution,and its performance is decent yet not great - 10X slower than the Java solution
	// using Stern-Brocot tree (or based on)
//	override fun solve(): Any {
//		var count = 0
//		for (d in 2..12000) {
//			for (n in d / 3 + 1..d / 2) {
//				if (n * 2 >= d) break
//				if (n * 3 <= d) continue
//				if (gcd(n, d) == 1) {
//					count++
//				}
//			}
//		}
//		return count
//	}
}