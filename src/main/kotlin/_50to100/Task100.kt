package se.embuc._50to100

import se.embuc.Task

//Arranged Probability
class Task100 : Task {

	override fun solve(): Long {
		//Diophantine solution
		var b: Long = 15
		var n: Long = 21
		while (n < 1000000000000) {
			val btemp = 3 * b + 2 * n - 2
			val ntemp = 4 * b + 3 * n - 3
			b = btemp
			n = ntemp
		}
		return b
	}
}