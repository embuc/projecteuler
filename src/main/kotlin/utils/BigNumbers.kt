package se.embuc.utils

import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

/**
 * Calculates the square root of a BigDecimal value with a specified scale of precision.
 *
 * This function uses the Newton-Raphson iteration method to approximate the square root of the given BigDecimal.
 * The Newton-Raphson method is an efficient algorithm for finding successively better approximations to the
 * roots (or zeroes) of a real-valued function. In this case, it's used to approximate the square root of 'value'.
 *
 * @param value The BigDecimal value to find the square root of. It must be a non-negative number.
 * @param scale The scale of the precision for the square root. The result will be rounded to this scale.
 * @return Returns the square root of 'value' as a BigDecimal, rounded to the specified 'scale' of precision.
 *
 * The algorithm starts with an initial guess for the square root, then iteratively improves this guess using the
 * Newton-Raphson formula: x_{n+1} = (x_n + value / x_n) / 2. The iteration continues until the difference between
 * successive approximations is less than 10^(-scale), ensuring the result is accurate to the specified precision.
 *
 * @throws ArithmeticException if 'value' is negative, as the square root of a negative number is not defined in the real numbers.
 */
fun sqrt(value: BigDecimal, scale: Int): BigDecimal {
	if (value.compareTo(BigDecimal.ZERO) < 0) {
		throw IllegalArgumentException("Square root of negative value")
	}

	// Define the precision for the intermediate calculations.
	val mc = MathContext(scale + 10, RoundingMode.HALF_UP)

	// Initial guess can be the half of the value's scale or a fixed starting point like 1 for non-zero values.
	var x0 = BigDecimal("1", mc)
	if (value.compareTo(BigDecimal.ZERO) == 0) {
		return BigDecimal.ZERO.setScale(scale, RoundingMode.HALF_UP) // Directly return 0 for sqrt(0)
	}

	var x1 = BigDecimal(Math.sqrt(value.toDouble()), mc) // A better initial guess to speed up convergence

	while (true) {
		// Newton-Raphson iteration
		val x1Prev = x1
		x1 = value.divide(x1, mc).add(x1).divide(BigDecimal.valueOf(2), mc)

		// Check for convergence within the desired precision, adjusted to scale.
		if (x1.subtract(x1Prev).abs().compareTo(BigDecimal(1, mc).movePointLeft(scale)) < 0) {
			break
		}
	}

	// Final rounding to the requested scale
	return x1.setScale(scale, RoundingMode.HALF_UP)
}

fun BigDecimal.hasNonZeroDecimalDigits(): Boolean {
	// Strip any trailing zeros to avoid false positives
	val strippedValue = this.stripTrailingZeros()
	// Compare the stripped value to its integer part (scaled to 0 without decimal digits)
	return strippedValue.compareTo(strippedValue.setScale(0, RoundingMode.DOWN)) != 0
}

fun BigDecimal.digitsSum(): Int {
	return this.toPlainString()
		.replace(".", "")
		.substring(0, 100)
		.map { Character.getNumericValue(it) }
		.sum()
}