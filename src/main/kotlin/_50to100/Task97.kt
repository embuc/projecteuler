package se.embuc._50to100

import se.embuc.Task

//Large Non-Mersenne Prime
class Task97 : Task {

	override fun solve(): Any {
		var num = 2L
		for (i in 1..<7830457) {
			num = (num * 2) % 10000000000L
		}
		num = (num * 28433) % 10000000000L
		return num + 1
	}
}