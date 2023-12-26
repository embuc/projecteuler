package se.embuc

import se.embuc.utils.findNextPrime

/* 10001st prime */
class Task7: Task {
	override fun solve(): Any {
		return nthPrime(10_001)
	}

	private fun nthPrime(i: Int): Any {
		var count = 1
		var prime = 2L
		while (count < i) {
			prime = findNextPrime(prime)
//			if(count > 9999)
//			println("" + count + " " + prime)
			count++
		}
		return prime
	}
}