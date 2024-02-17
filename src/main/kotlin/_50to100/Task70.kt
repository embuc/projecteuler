package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.getPrimesBelow
import se.embuc.utils.isPermutation

// Totient permutation
class Task70 : Task {
	override fun solve(): Any {
		var minN = 0
		var minRatio = 10000000.0

		val primes: Pair<List<Int>, BooleanArray> = getPrimesBelow(5000000)
		val primeList = primes.first
		for (i in 1 until primeList.size) {
			for (j in 0 until i) {
				val p = primeList[i] * primeList[j]
				if (p > 10000000) {
					break
				}
				val phi = (primeList[i] - 1) * (primeList[j] - 1)
				val ratio = p.toDouble() / phi.toDouble()
				if (ratio < minRatio) {
					if (isPermutation(p, phi)) {
						minRatio = ratio
						minN = p
					}
				}
			}
		}
		return minN
	}
	// Brute force (~3sec):
//	override fun solve(): Any {
//		var minN = 0
//		var minRatio = 10_000_000.toDouble()
//
//		for (i in 2..10_000_000) {
//			val phi = phi(i)
//			var ratio = i / phi.toDouble()
//			if (ratio < minRatio) {
//				if (isPermutation(i, phi)) {
//					minRatio = ratio
//					minN = i
//				}
//			}
//		}
//		return minN;
//	}
}