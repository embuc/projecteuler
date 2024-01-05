package se.embuc._1to50

import se.embuc.Task

// Sub-string divisibility
class Task43 : Task {
	override fun solve(): Any {
		val divisorPrimes = listOf(13, 11, 7, 5, 3, 2, 1)
		val validPermutations = (102..999 step 17).map { it.toString() }.filter { it.toSet().size == 3 }//ensure we skip any with duplicate digits (toSet().size == 3)
		return backtrackByDivisors(divisorPrimes, validPermutations)
	}

	fun backtrackByDivisors(primeDivisors: List<Int>, validPermutations: List<String>): Long {
		val divisor = primeDivisors.first() // 2, left is 3, 5, 7, 11, 13, 17 (first run, then recurse)
		val remainingDivisors = primeDivisors.drop(1)
		val numbers = mutableListOf<String>()

		for (permutation in validPermutations) {
			for (digit in "0123456789") {
				if (digit !in permutation) { //ensure pandigital
					val nextPermutation = digit + permutation
					if (nextPermutation.substring(0, 3).toInt() % divisor == 0) {
						numbers.add(nextPermutation)
					}
				}
			}
		}

		return if (remainingDivisors.isEmpty()) {
			numbers.sumOf { it.toLong() }
		} else {
			backtrackByDivisors(remainingDivisors, numbers)
		}
	}

}