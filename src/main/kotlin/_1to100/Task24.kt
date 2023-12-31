package se.embuc._1to100

import se.embuc.Task
import se.embuc.utils.computeNthPermutation

// Lexicographic Permutations (There is a naive solution in the Utils class, but it runs in 1 second vs 10ms for this
// one)
class Task24:Task {
	override fun solve(): Any {
		val digits = "0123456789"
		return computeNthPermutation(digits.toMutableList(), 1_000_000)
	}

}