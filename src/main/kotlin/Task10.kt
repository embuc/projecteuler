package se.embuc

import se.embuc.utils.findNextPrime

/**
 * https://projecteuler.net/problem=10
 * Summation of primes
 * Created by embuc on 2023-12-27.
 */
class Task10: Task{

	override fun solve(): Any {
		return sumOfPrimesBelow(2_000_000)
	}

	private fun sumOfPrimesBelow(n: Int): Long {
		var i = 2L
		var sum = 2L
		while (i < n) {
			i = findNextPrime(i)
			if(i<n)
				sum += i
		}
		return sum
	}

}