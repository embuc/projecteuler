package se.embuc._1to100

import se.embuc.Task

class Task8(private val input:String): Task {
	override fun solve(): Any {
		return largestProduct(input, 13)
	}

	private fun largestProduct(input: String, n: Int): Long {
		var largestProduct = 0L
		for (i in 0..input.length - n) {
			val product = input.substring(i, i + n)
				.map { it.toString().toLong() }
				.reduce { acc, l -> acc * l }
			if (product > largestProduct) {
				largestProduct = product
			}
		}
		return largestProduct
	}
}