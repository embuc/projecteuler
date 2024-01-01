package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.isPrime
import kotlin.math.sqrt

// Quadratic Primes
// Problem 27 optimization rules:
//1. a and b must both be odd (due to rules about adding even and odd integers, and that all primes are odd)
//2. b must be prime (due to the n = 0 case).
//3. a + b + 1 must be prime (due to the n = 1 case).
//4. If the LCM of a and b (a * b, because b is prime) is less than the max number of n we've found so far, there's no
//need to check it.
class Task27:Task {
	private val maxB = 1000
	private val primes: BooleanArray = BooleanArray(maxB) { it >= 2 }.apply {
		// Sieve of Eratosthenes for prime generation
		for (i in 2 until sqrt(this.size.toDouble()).toInt()) {
			if (this[i]) {
				for (j in i * i until this.size step i) {
					this[j] = false
				}
			}
		}
	}

	override fun solve(): Long {
		var max = 0L
		var maxA = 0L
		var maxB = 0L

		for (b in 2 until this.maxB) {
			if (!primes[b]) continue // b must be prime
			for (a in -999..999) {
				if (a % 2 == 0 && b % 2 == 0) continue // Ensure a+b+1 is odd
				var n = 0L
				while (isPrime(n * n + a * n + b)) {
					n++
				}
				if (n > max) {
					max = n
					maxA = a.toLong()
					maxB = b.toLong()
				}
			}
		}
		return maxA * maxB
	}


}