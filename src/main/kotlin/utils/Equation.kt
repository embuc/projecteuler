package se.embuc.utils

fun solveQuadratic(a: Double, b: Double, c: Double): Pair<Double?, Double?> {
	if (a == 0.0) {
		// Not a quadratic equation
		return null to null
	}

	val discriminant = b * b - 4 * a * c

	return if (discriminant > 0) {
		// Two real and distinct roots
		Pair((-b + kotlin.math.sqrt(discriminant)) / (2 * a), (-b - kotlin.math.sqrt(discriminant)) / (2 * a))
	} else if (discriminant == 0.0) {
		// One real root (roots are equal)
		Pair(-b / (2 * a), -b / (2 * a))
	} else {
		// Roots are complex and different
		null to null
	}
}