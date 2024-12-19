package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.getPrimesBelow
import kotlin.math.pow
import kotlin.math.sqrt

//Prime Power Triples
class Task87:Task {
	override fun solve(): Any {
		return findPrimePowerTriples()
	}

	private fun findPrimePowerTriples(): Any {
//		The smallest number expressible as the sum of a prime square, prime cube, and prime fourth power is
//		. In fact, there are exactly four numbers below fifty that can be expressed in such a way:
//		28 = 2^2 + 2^3 + 2^4
//		33 = 3^2 + 2^3 + 2^4
//		49 = 5^2 + 2^3 + 2^4
//		47 = 2^2 + 3^3 + 2^4
//		How many numbers below fifty million can be expressed as the sum of a prime square, prime cube, and prime fourth power?
		val limit = 50_000_000
		val primes = getPrimesBelow(sqrt(limit.toDouble()).toInt()).first

		val results = mutableSetOf<Int>() // To store unique sums

		for (p1 in primes) {
			val square = p1.toDouble().pow(2).toInt()
			if (square >= limit) break

			for (p2 in primes) {
				val cube = p2.toDouble().pow(3).toInt()
				if (square + cube >= limit) break

				for (p3 in primes) {
					val fourth = p3.toDouble().pow(4).toInt()
					val sum = square + cube + fourth

					if (sum >= limit) break
					results.add(sum)
				}
			}
		}
		return results.size
	}

}