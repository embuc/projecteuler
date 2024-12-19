package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.getIntMagnitude
import se.embuc.utils.getPrimesSieveBelow

//Circular primes
class Task35 : Task {

	override fun solve(): Any {
		val primes = getPrimesSieveBelow(1_000_000)
		var count = 2 // 2 and 3 are circular primes
		for (i in 6 until primes.size step 6) { // utilize the fact that all primes > 3 are of the form 6k +/- 1
			if (primes[i - 1]) {
				count += rotateAndCheck(i - 1, primes)
			}
			if (primes[i + 1]) {
				count += rotateAndCheck(i + 1, primes)
			}
		}
		return count
	}

	fun rotateAndCheck(i: Int, primes: BooleanArray): Int {
		var n = i
		var (exp, log) = getIntMagnitude(i)
		// Loop (Rotation Check):
		// The rotation works as follows: n / exp gets the first digit of n, and 10 * n shifts all digits of n one
		// position to the left. Adding these two results places the first digit of n at the end. The modulo operation
		// ensures that the number remains in the same magnitude (i.e., the number of digits doesn't increase).
		while (log-- > 0) {
			n = (10 * n + n / exp) % (10 * exp)
			if (!primes[n]) return 0
		}

		return 1
	}

}

