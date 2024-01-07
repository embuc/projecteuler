package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.isPermutation

// Permuted multiples
class Task52 : Task {
	override fun solve(): Any {
		var number = 123456
		while (true) {
			val products = (2..6).map { it * number }.filter { isPermutation(it, number) }
			if (products.size == 5) {
				return number
			}
			number++
		}
		return -1
	}
}