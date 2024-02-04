package se.embuc._50to100

import se.embuc.Task

// Totient maximum
class Task69 : Task {
	override fun solve(): Any {
		val n = 1_000_000
		var max = 0.0
		var maxN = 0
		for (i in 1..n) {
			var phi = phi(i)
			val ratio = i / phi.toDouble()
			if (ratio > max) {
				max = ratio
				maxN = i
			}
		}
		return maxN
	}

//	Using euler's totient function and avoiding floating point division
	fun phi(n: Int): Int {
		var n = n
		var result = n

		var i = 2
		while (i * i <= n) {
			if (n % i == 0) {
				while (n % i == 0) n /= i
				result -= result / i
			}
			i++
		}

		if (n > 1) result -= result / n
		return result
	}
}