package se.embuc._1to50

import se.embuc.Task
import java.math.BigInteger

// Fibonacci numbers 1000-digit
class Task25: Task {
	override fun solve(): Any {
		var prev = BigInteger.ONE
		var curr = BigInteger.ONE

		// Define the smallest number with 1000 digits
		val minLimit = BigInteger.TEN.pow(999) // 10^999
		var count = 2

		while (curr.compareTo(minLimit) < 0) {
			val next = prev.add(curr)
			prev = curr
			curr = next
			count++
		}

		return count
	}
}