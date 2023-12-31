package se.embuc._1to100

import se.embuc.Task

// Reciprocal cycles
class Task26 : Task {
	override fun solve(): Any {
		val limit = 1000
		var max = 0
		var d = 0
		for (i in 1 until limit) {
			val cycle = getCycle(i)
			if (cycle > max) {
				max = cycle
				d = i
			}
		}
		return d
	}

	fun getCycle(n: Int): Int {
		val seenRemainders = BooleanArray(n + 1)
		var remainder = 1
		var length = 0

		while (!seenRemainders[remainder]) {
			seenRemainders[remainder] = true
			remainder *= 10
			remainder = remainder % n
			length++
		}

		return length
	}
}