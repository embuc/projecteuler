package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.isPrime

// Spiral Primes
class Task58: Task {
	override fun solve(): Any {
		var count = 0;
		var i = 1
		while (true) {
			val odd = 2 * i + 1
			val biggest = odd * odd
			for (j in 1..3) {
				val next = biggest - j * (odd-1)
				if(isPrime(next)) {
					count++
				}
			}
			val diagonalElements = 4 * i + 1
			val sideLength = odd
			val ratio = count.toDouble() / diagonalElements
			if(ratio < 0.1) return sideLength
			i++
		}
		return -1
	}
}