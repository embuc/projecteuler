package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.isPanDigit

// Pandigital products
class Task32 : Task {
	override fun solve(): Any {
		val products = mutableSetOf<Int>()
		for (a in 4..98) {
			if (a % 10 != 0 && a % 11 != 0) {
				for (b in 123..9876/a) {
					val product = a * b
					if (product > 9876 || product < 1234) {
						continue
					}
					if (isPanDigit(intArrayOf(a, b, product))) {
						products.add(product)
					}
				}
			}
		}
		return products.sum()
	}

}