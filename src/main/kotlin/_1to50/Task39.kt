package se.embuc._1to50

import se.embuc.Task

class Task39 :Task {
	override fun solve(): Any {
		var max = 0
		var maxP = 0
		for (p in 1..1000) {
			var count = 0
			for (a in 1 until p) {
				for (b in a until p) {
					val c = p - a - b
					if (a * a + b * b == c * c) {
						count++
					}
				}
			}
			if (count > max) {
				max = count
				maxP = p
			}
		}
		return maxP
	}
}