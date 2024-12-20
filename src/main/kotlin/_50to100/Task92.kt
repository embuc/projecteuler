package se.embuc._50to100

import se.embuc.Task

//Square Digit Chains
class Task92() : Task {

	override fun solve(): Any {
		//how many under 10000000 end in 89
		val known = IntArray(10_000_000)
		known[89] = 89
		known[1] = 1

		for (i in 2 until 10_000_000) {
			var current = i

			while (known[current] == 0) {
				current = current.next()
			}

			known[i] = known[current]
		}

		val count = known.count { it == 89 }

		return count // Return the result
	}

	private fun Int.next(): Int {
		var n = this
		var sum = 0
		while (n > 0) {
			val digit = n % 10
			sum += digit * digit
			n /= 10
		}
		return sum
	}
}