package se.embuc._1to100

import se.embuc.Task
import se.embuc.utils.isDivisibleByAll
import se.embuc.utils.lcm

/** Smallest Multiple */
class Task5: Task {

	override fun solve(): Any {
		var result = 1L
		for (i in 2..20) {
			result = lcm(result, i.toLong())
		}
		return result
	}

	//cca 250ms >1000x slower
	private fun bruteForce(): Long {
		var n = 20L
		while (!isDivisibleByAll(n, 20L)) {
			n++
		}
		return n
	}

}