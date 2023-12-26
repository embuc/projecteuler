package se.embuc.k

import se.embuc.Task
import se.embuc.utils.Utils.findNextPrime

/* Largest Prime factor */
class Task3(private var q:Long) : Task {


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