package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.factorialBig
import java.math.BigInteger

// Combinatoric selections
class Task53 : Task {
	override fun solve(): Any {
		var count = 0
		for (n in 1..100) {
			for (r in 1..n) {
				val nCr = combinations(n, r)
				if (nCr > BigInteger.valueOf(1_000_000)) {
					count++
				}
			}
		}
		return count
	}

	private fun combinations(n: Int, r: Int): BigInteger {
		return  factorialBig(n) / factorialBig(r).multiply(factorialBig(n - r))
	}
}