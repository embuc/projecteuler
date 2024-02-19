package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.phi

// Counting fractions
class Task72:Task {
	override fun solve(): Any {
		var count = 0.toLong()
		for (d in 2..1000000) {
			count += phi(d)
		}
		return count
	}
}