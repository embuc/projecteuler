package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.getPrimesBelow

// Prime digit replacements
class Task51:Task {
	override fun solve(): Any {
		val (primes, sieve) = getPrimesBelow(1_000_000)
		val length = 8
		primes.forEach { prime ->
			if(prime < 56000) {
				return@forEach
			}
			val patterns = generatePatterns(prime)
			patterns.forEach { pattern ->
				val primesInPattern = countPrimesInPattern(pattern, sieve)
				if (primesInPattern.size == length) {
					return primesInPattern.minOrNull()!!
				}
			}
		}
		return 0
	}

	fun generatePatterns(prime: Int): Set<String> {
		val primeStr = prime.toString()
		val length = primeStr.length
		val patterns = mutableSetOf<String>()
		// generate 2^n patterns, where n is the number of digits in the prime
		(1 until (1 shl length)).forEach { mask ->
			val pattern = StringBuilder(primeStr)
			for (i in 0 until length) {
				if (mask and (1 shl i) != 0) {
					pattern[i] = '*'
				}
			}
			patterns.add(pattern.toString())
		}
		return patterns
	}

	fun countPrimesInPattern(pattern: String, sieve: BooleanArray): MutableSet<Int> {
		var set = mutableSetOf<Int>()
		(0..9).forEach { digit ->
			if (pattern[0] == '*' && digit == 0
				|| pattern[pattern.length-1] == '*' // it can not be tha last digit because it would not be 8 primes
				) {
				// Skip leading zero
				return@forEach
			}

			val number = pattern.replace('*', digit.toString().first())
			if (sieve[number.toInt()]) {
				set.add(number.toInt())
			}
		}
		return set
	}

}