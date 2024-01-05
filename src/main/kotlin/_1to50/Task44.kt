package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.getPentagonalNumbers

// Pentagonal numbers
class Task44 : Task {
	override fun solve(): Any {
		val (keys, dict) = getPentagonalNumbers(5000)
		for (i in 0..(keys.size/2)) {
			for (j in (i + 1)..(keys.size/2)) {
				val sum = keys[i] + keys[j]
				val diff = keys[j] - keys[i]
				if (dict[diff] && dict[sum]) {
					return diff
				}
			}
		}
		return -1
	}
}