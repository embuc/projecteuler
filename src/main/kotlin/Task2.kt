package se.embuc

/**
 * Even Fibonacci Numbers
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms
 * */
class Task2 : Task {

	override fun solve(): Any {
		var sum = 0
		var prev = 1
		var curr = 2
		var next = curr
		while (next < 4_000_000) {
			if (next % 2 == 0) {
				sum += next
			}
			next = prev + curr
			prev = curr
			curr = next
		}

		return sum
	}
}