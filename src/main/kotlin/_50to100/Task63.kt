package se.embuc._50to100

import se.embuc.Task
import java.math.BigInteger

// Powerful digit counts.
// For each base > 10, the number of digits in base^exp is bigger than exp, so these can be omitted.
// For each exp > 21, the number of digits in base^exp is less than exp, so these can be omitted too
// (e.g., 2^22 has 7 digits, 9^22 has 21 digits, etc.)
class Task63 : Task {
	override fun solve(): Any {
		var count = 1 //1^1 case
		for (base in 1..9) {
			for (exp in 1..100) {
				val result = BigInteger.valueOf(base.toLong()).pow(exp)
				val upperLimit = BigInteger.TEN.pow(exp)
				if (result > BigInteger.TEN.pow(exp - 1) && result < upperLimit) {
					count++
				} else if (result > upperLimit) {
					break
				}
			}
		}
		return count
	}
}