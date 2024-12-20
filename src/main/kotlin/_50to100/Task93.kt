package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.allCombinationsOfFourDigits
import se.embuc.utils.permute

//Arithmetic Expressions
class Task93():Task {

	override fun solve(): Any {
		return findBestSet()
	}

	fun findBestSet(): String {
		var longestSequence = 0
		var bestSet = ""

		// Step 1: Iterate over all combinations of 4 digits
		for (digits in allCombinationsOfFourDigits()) {
			val results = mutableSetOf<Int>()

			// Step 2: Generate permutations of the digits
			for (perm in permute(digits)) {
				// Step 3: Use backtracking to evaluate all possible expressions
				backtrack(perm.map { it.toDouble() }, results)
			}

			// Step 4: Find the longest sequence of consecutive integers from the results
			val consecutiveLength = findConsecutiveLength(results)
			if (consecutiveLength > longestSequence) {
				longestSequence = consecutiveLength
				bestSet = digits.sorted().joinToString("") // Store as a string
			}
		}

		return bestSet
	}


	fun backtrack(numbers: List<Double>, results: MutableSet<Int>) {
		// Base case: Only one number left
		if (numbers.size == 1) {
			val result = numbers[0]
			if (result > 0 && result == result.toInt().toDouble()) {
				results.add(result.toInt())
			}
			return
		}

		// Try all pairs of numbers and apply all operations
		for (i in numbers.indices) {
			for (j in numbers.indices) {
				if (i == j) continue // Skip same index

				val num1 = numbers[i]
				val num2 = numbers[j]
				val remaining = numbers.filterIndexed { index, _ -> index != i && index != j } // Remaining numbers

				// Apply operations
				listOf(
					num1 + num2,
					num1 - num2,
					num1 * num2,
					if (num2 != 0.0) num1 / num2 else null // Division (avoid divide by zero)
				).filterNotNull().forEach { result ->
					backtrack(remaining + result, results) // Recurse with the new number list
				}
			}
		}
	}

	fun findConsecutiveLength(results: Set<Int>): Int {
		val sorted = results.sorted()
		var count = 0
		for (i in sorted) {
			if (i == count + 1) {
				count++
			} else if (i > count + 1) {
				break
			}
		}
		return count
	}

}