package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.getPrimesBellow

// Goldbach's other conjecture
class Task46 : Task {
	override fun solve(): Any {
		val limit = 10_000
		val (primes, sieve) = getPrimesBellow(limit)
		for (composite in 33..limit step 2) {
			if (sieve[composite]) continue
			var foundSquare = false
			for (prime in primes) {
				if (prime > composite) break
				val diff = composite - prime
				val sqrt = Math.sqrt((diff / 2).toDouble())
				if (sqrt == sqrt.toInt().toDouble()) {
					foundSquare = true
					break
				}
			}
			if (!foundSquare) return composite
		}
		return -1
	}


}