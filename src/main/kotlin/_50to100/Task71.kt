package se.embuc._50to100

import se.embuc.Task

// Ordered fractions
class Task71 : Task {

	override fun solve(): Any {
		val i = 1000000 / 7
		val j = 1000000 % 7
		val targetD = 1000000 - j
		val targetN = i * 3 - 1
		return targetN
	}
}