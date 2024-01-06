package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.primeFactorsCount

// Distinct primes factors
class Task47 : Task {
	override fun solve(): Any {
		var result = -1
		var i = 2 * 3 * 5 * 7
		while (true) {
			var count = 0
			var allPrime = true
			for (j in 0..3) {
				val divisors = primeFactorsCount(i + j)
				if (divisors != 4) {
					allPrime = false
					i += 1 + j
					break
				}
				if (!allPrime) break
			}
			if (allPrime){
				result = i
				break
			}
		}
		return result
	}

}