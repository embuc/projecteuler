package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.gcd

// Digit cancelling fractions
class Task33 : Task {
	override fun solve(): Any {
		var numerators: MutableList<Long> = mutableListOf()
		var denominators: MutableList<Long> = mutableListOf()
		for (a in 11..98L) {
			for (b in (a + 1)..99L) {
				if (a % 10 == 0L || b % 10 == 0L) continue
				val a1 = a / 10
				val a2 = a % 10
				val b1 = b / 10
				val b2 = b % 10
				/* If I understood this Task correctly, only '3rd' if-case is needed,
				* the definition of non-trivial 'curious' fraction was a bit vague.
				* This version gives correct result. */
				if (
//					a1 == b1 && a * b2 == b * a2 // Matches tens digits; equivalent after removing tens digits. Doesn't seem to occur.
//					|| a1 == b2 && a * b1 == b * a2 // Matches tens digit of 'a' with units digit of 'b'; equivalent after cross-removing these digits. Doesn't seem to occur.
					a2 == b1 && a * b2 == b * a1 // Matches units digit of 'a' with tens digit of 'b'; equivalent after cross-removing these digits.
//					|| a2 == b2 && a * b1 == b * a1 // Matches units digits; equivalent after removing units digits. Doesn't seem to occur.
				) {
					numerators.add(a)
					denominators.add(b)
				}
			}
		}
		val numerator = numerators.reduce { acc, l -> acc.times(l) }
		val denominator = denominators.reduce { acc, l -> acc.times(l) }
		return denominator / gcd(numerator, denominator)
	}

}