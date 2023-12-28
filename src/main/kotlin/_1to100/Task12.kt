package se.embuc._1to100

import se.embuc.Task
import se.embuc.utils.getDivisorsCount
import se.embuc.utils.getTriangleNumber


/**
 * Highly divisible triangular number
 * When calculating the triangular number, remember that each triangular number is half the product of two consecutive
 * integers (n * (n+1)/2). Hence, you can calculate the number of divisors of a triangular number by calculating the divisors of
 * these two numbers separately. Note that one of n or n+1 is always even, so you can divide the even number by 2
 * before calculating divisors.
 *
 * */
class Task12 : Task {

	override fun solve(): Any {
		val target = 500L
		var i = 1L

		while (true) {
			var divisorCount = if (i % 2 == 0L) {
				getDivisorsCount(i / 2) * getDivisorsCount(i + 1)
			} else {
				getDivisorsCount(i) * getDivisorsCount((i + 1) / 2)
			}

			if (divisorCount > target) {
				return getTriangleNumber(i)
			}
			i++
		}
	}
}