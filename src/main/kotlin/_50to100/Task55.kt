package se.embuc._50to100

import se.embuc.Task
import java.math.BigInteger

// Lychrel Numbers
class Task55 : Task {
	override fun solve(): Any {
		var count = 0;
		for (i in 1..10000) {
			if (isLychrel(i.toBigInteger())) {
				count++
			}
		}
		return count
	}

	private fun isLychrel(i: BigInteger): Boolean {
		var n = i
		for (j in 1..50) {
			n = n + n.toString().reversed().toBigInteger()
			if (n.toString().reversed() == n.toString()) {
				return false
			}
		}
		return true
	}
}