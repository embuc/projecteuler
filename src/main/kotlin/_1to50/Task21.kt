package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.getDivisorsSum

//Amicable Numbers
class Task21:Task {

	// this solution reads better but its slower actually as maps have O(log n) access time
//	override fun solve(): Any {
//		val dict = mutableMapOf<Long, Long>()
//		for(i in 1..10000L) {
//			val sumOfDivisors = getDivisorsSum(i)
//			dict[i] = sumOfDivisors
//		}
//		return dict.filter { it.key != it.value && dict[it.value] == it.key }.keys.sum()
//	}

	override fun solve(): Any {
		val limit = 10000
		val sumOfDivisors = LongArray(limit + 1) { 0 }

		// Compute sum of divisors for each number
		for (i in 1..limit) {
			sumOfDivisors[i] = getDivisorsSum(i.toLong())
		}

		var sum = 0L
		for (i in 2..limit) {
			val divSum = sumOfDivisors[i].toInt()
			if (divSum <= limit && divSum != i && sumOfDivisors[divSum] == i.toLong()) {
				sum += i
			}
		}

		return sum
	}
}