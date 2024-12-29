package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.allCombinationsOfFourDigits

//Arithmetic expressions
class Task93 : Task {
	private val expressionCache = mutableMapOf<String, Set<Int>>()

	// Early termination threshold
	private val maxPossibleSequence = 100

	override fun solve(): Any {
		return findBestSet()
	}

	fun findBestSet(): String {
		var longestSequence = 0
		var bestSet = ""

		// Pre-sort combinations to avoid repeated sorting
		val combinations = allCombinationsOfFourDigits().map { it.sorted().joinToString("") }

		for (digits in combinations) {
			// Check if we've already computed this combination
			val results = expressionCache.getOrPut(digits) {
				val tempResults = mutableSetOf<Int>()
				backtrack(digits.map { it.toString().toDouble() }, tempResults)
				tempResults
			}

			val consecutiveLength = findConsecutiveLength(results)
			if (consecutiveLength > longestSequence) {
				longestSequence = consecutiveLength
				bestSet = digits

				// Early termination if we've found a sufficiently long sequence
				if (longestSequence >= maxPossibleSequence) break
			}
		}

		return bestSet
	}

	fun backtrack(numbers: List<Double>, results: MutableSet<Int>) {
		// Early pruning: Skip if the partial result is too large
		if (numbers.any { it > 10000 }) return

		if (numbers.size == 1) {
			val result = numbers[0]
			// Add bounds checking for practical results
			if (result > 0 && result <= maxPossibleSequence * 2 && result == result.toInt().toDouble()) {
				results.add(result.toInt())
			}
			return
		}

		// Use ranges instead of indices for better performance
		for (i in numbers.indices) {
			for (j in (i + 1)..numbers.lastIndex) {
				val num1 = numbers[i]
				val num2 = numbers[j]
				val remaining = numbers.filterIndexed { index, _ -> index != i && index != j }

				computeOperations(num1, num2, remaining, results)
			}
		}
	}

	private fun computeOperations(num1: Double, num2: Double, remaining: List<Double>, results: MutableSet<Int>) {
		// Addition and multiplication are commutative, so we only need to compute them once
		tryOperation(num1 + num2, remaining, results)
		tryOperation(num1 * num2, remaining, results)

		// Non-commutative operations need both orderings
		tryOperation(num1 - num2, remaining, results)
		tryOperation(num2 - num1, remaining, results)

		if (num2 != 0.0) tryOperation(num1 / num2, remaining, results)
		if (num1 != 0.0) tryOperation(num2 / num1, remaining, results)
	}

	private fun tryOperation(result: Double, remaining: List<Double>, results: MutableSet<Int>) {
		// Early pruning: Skip if the result is not promising
		if (result.isFinite() && result > 0 && result <= maxPossibleSequence * 2) {
			backtrack(remaining + result, results)
		}
	}

	fun findConsecutiveLength(results: Set<Int>): Int {
		// Optimize by using direct iteration instead of sorting
		var count = 0
		var current = 1

		while (results.contains(current)) {
			count++
			current++

			// Early termination if we've found a sufficiently long sequence
			if (count >= maxPossibleSequence) break
		}

		return count
	}
}