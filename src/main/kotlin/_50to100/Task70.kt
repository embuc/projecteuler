package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.isPermutation
import se.embuc.utils.phi

// Totient permutation
class Task70:Task {
	override fun solve(): Any {
		var minN = 0
		var minRatio = 10_000_000.toDouble()

		for (i in 2..10_000_000) {
			val phi = phi(i)
			if (isPermutation(i, phi)) {
				var ratio = i / phi.toDouble()
				if (ratio < minRatio) {
					minRatio = ratio
					minN = i
				}
			}
		}
		return minN;
	}
}