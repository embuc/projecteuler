package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.getPrimesSieveBelow

/* 10001st prime */
class Task7 : Task {
	override fun solve(): Any {
		return nthPrime(10_001)
	}

	private fun nthPrime(nth: Int): Any {
		var limit = 2 * nth * 6 + 1
		var primes = getPrimesSieveBelow(limit)

		var count = 2
		for (i in 6..primes.size step 6) {
			var prime = 0;
			if (primes[i + 1]) {
				count++
				prime = i + 1
			}
			if (primes[i - 1]) {
				count++
				prime = i + 1
			}

			if (count == nth)
				return prime
		}
		return -1
	}
}