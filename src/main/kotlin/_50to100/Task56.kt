package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.digits

// Powerful digit sum
class Task56:Task {
	override fun solve(): Any {
		var max = 0
		for (a in 1..100) {
			for (b in 1..100) {
				val sum = a.toBigInteger().pow(b).digits().sum()
				if (sum > max) {
					max = sum
				}
			}
		}
		return max
	}
}


