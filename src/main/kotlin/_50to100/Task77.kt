package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.getPrimesBelow

//Prime Summations
class Task77 : Task {
	override fun solve(): Any {
		val primes = getPrimesBelow(100)
		val target = 5000
		val ways = IntArray(target + 1)
		ways[0] = 1
		for (prime in primes.first) {
			for (i in prime..100) {
				ways[i] += ways[i - prime]
			}
		}
		for (i in 0..target) {
			if (ways[i] > 5000) {
				return i
			}
		}
		return 0
	}
}