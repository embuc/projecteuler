package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.solvePell
import java.math.BigInteger

// Diophantine equation
// Pell's equation, also called the Pell–Fermat equation, is any Diophantine equation of the form
// x^2-ny^2=1, where n is a given positive nonsquare integer, and integer solutions are sought for x and y.
// So, we skip perfect squares (e.g., 9 because 3^2=9)
class Task66 : Task {

	override fun solve(): Any {
		var maxX = BigInteger.ZERO
		var maxN = 0
		for (n in 2..1000) {
			if (isPerfectSquare(n)) {
				continue
			}
			val x = solvePell(n).numerator
			if (x != null) {
				if (x > maxX) {
					maxX = x
					maxN = n
				}
			}
		}
		return maxN
	}

	private fun isPerfectSquare(i: Int): Boolean {
		val sqrt = Math.sqrt(i.toDouble())
		return sqrt == sqrt.toInt().toDouble()
	}

}