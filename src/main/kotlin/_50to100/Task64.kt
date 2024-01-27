package se.embuc._50to100

import se.embuc.Task

class Task64:Task {
	override fun solve(): Any {
		var resultCount = 0
		val array = BooleanArray(10001)
		for (i in 1..100) {
			val square = i * i
			array[square] = true
		}
		for (number in 1..10000) {
			val initialSqrt = Math.sqrt(number.toDouble()).toInt()
			if (array[number]) continue

			var sqrtFloor = initialSqrt.toDouble()
			var denominator = 1.0
			var numerator = 0.0
			var remainder = 0.0
			var iterationCount = 0

			do {
				denominator = ((number - (sqrtFloor * sqrtFloor)) / denominator).toInt().toDouble()
				numerator = Math.floor((initialSqrt + sqrtFloor) / denominator)
				remainder = (initialSqrt + sqrtFloor) % denominator
				sqrtFloor = Math.abs(remainder - initialSqrt)
				iterationCount++
			} while (numerator.toInt() != (2 * initialSqrt))
			if (iterationCount % 2 == 1) {
				resultCount++
			}
		}
		return resultCount
	}
}