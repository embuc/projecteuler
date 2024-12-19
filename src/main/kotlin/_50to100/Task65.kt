package se.embuc._50to100

import se.embuc.Task
import java.math.BigInteger

// Convergents of e
/**
 * Computes the convergents of Euler's number e using a continued fraction expansion.
 * Euler's number e can be expressed as an infinite continued fraction:
 * e = 2 + 1/(1 + 1/(2 + 1/(1 + 1/(1 + ...))))
 * This represents the general pattern of the continued fraction for e:
 * 2, 1, 2, 1, 1, 4, 1, 1, 6, 1, 1, 8, ...
 *
 * The function calculates this using a reverse iteration approach, starting from the
 * last term of the desired convergent and working backward to the first term. It
 * effectively builds the fraction from the inside out of the continued fraction representation.
 */
class Task65:Task {
	override fun solve(): Any {
		val (num, _) = computeEConvergent(100)
		return num.toString().map { it.toString().toInt() }.sum()
	}

	fun computeEConvergent(terms: Int): Pair<BigInteger, BigInteger> {
		var numerator = BigInteger.ONE
		var denominator = BigInteger.ZERO

		for (i in terms - 1 downTo 0) {
			val term = nextFractionTerm(i)
			val temp = BigInteger.valueOf(term.toLong()).multiply(numerator).add(denominator)
			denominator = numerator
			numerator = temp
		}

		val gcd = numerator.gcd(denominator)
		return Pair(numerator.divide(gcd), denominator.divide(gcd))
	}

	private fun nextFractionTerm(i: Int): Int {
		return if (i == 0) 2 else if (i % 3 == 2) i / 3 * 2 + 2 else 1
	}

}