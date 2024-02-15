package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.phi

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

}