package se.embuc._1to100

import se.embuc.Task

// Number spiral diagonals
// On the right diagonal we have the squares of odd numbers, 1, 9, 25, 49, 81, which is also the
// biggest number on each 'level'. Then we have sum of all 4 diagonal numbers on that level as biggest - 'width'
// for first 2 * width for second etc.
class Task28:Task {
	override fun solve(): Any {
		var sum = 1L
		for (i in 1..500) {
			val odd = 2 * i + 1
			val biggest = odd * odd
			val diff = odd - 1
			sum += 4 * biggest - 6 * diff
			if(odd == 1001) break
		}
		return sum
	}
}