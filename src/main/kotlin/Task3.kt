package se.embuc

import se.embuc.Problem
import se.embuc.utils.Utils.findNextPrime

/* Largest Prime factor */
class Task3(private var q:Long) : Problem {


	override fun solve(): Any {
		var prime = 2L
		while (q > 1) {
			if (q % prime == 0L) {
				q /= prime
			} else {
				prime = findNextPrime(prime)
			}
		}

		return prime
	}
}