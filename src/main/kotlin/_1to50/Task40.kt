package se.embuc._1to50

import se.embuc.Task
import kotlin.math.pow

// Champernowne's constant
class Task40: Task {
	override fun solve(): Any {
		val s = StringBuilder()
		for (i in 1..200000) {//there are more decimals using 200_000 natural numbers than needed
			s.append(i)
		}
		var result = 1
		for (i in 0..6) {
			result *= s[10.0.pow(i.toDouble()).toInt() - 1].code - '0'.code
		}
		return result
	}


}