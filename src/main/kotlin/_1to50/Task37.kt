package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.getIntMagnitude
import se.embuc.utils.getPrimesSieveBelow

//Truncatable primes
class Task37 : Task {
	override fun solve(): Any {
		var sum = 0
		val primes = getPrimesSieveBelow(1_000_000)
		for (i in 18 until primes.size step 6) {
			if (primes[i + 1]) {
				if (isTruncatablePrime(i + 1, primes)) {
					sum += i + 1
				}
			}
			if (primes[i - 1]) {
				if (isTruncatablePrime(i - 1, primes)) {
					sum += i - 1
				}
			}
		}
		return sum
	}

	fun isTruncatablePrime(i: Int, sieve: BooleanArray): Boolean {
		var n = i
		while (n > 0) {
			if (!sieve[n]) {
				return false
			}
			n /= 10
		}
		var (exp, log) = getIntMagnitude(i)
		n = i
		while (log > 0) {
			if (!sieve[n]) {
				return false
			}
			n %= exp
			exp /= 10
			log--
		}
		return true
	}
}