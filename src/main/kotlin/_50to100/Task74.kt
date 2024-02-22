package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.digits
import se.embuc.utils.factorialUnder10

// Digit factorial chains
class Task74: Task {
	override fun solve(): Any {
		var count = 0
		for (i in 69..1_000_000) {
			var length = countFactorialChain(i)
			if (length == 60) {
				count++
			}
		}
		return count
	}

	private fun countFactorialChain(i: Int): Any {
		var set = mutableSetOf<Int>()
		set.add(i)
		var num = i
		while (true) {
			var count = 0
			var digits = num.digits()
			for (d in digits) {
				count += factorialUnder10(d)
			}
			num = count
			if (set.contains(num)) {
				break
			}
			set.add(num)
		}
		return set.size
	}
}