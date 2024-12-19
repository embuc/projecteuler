package se.embuc._1to50

import se.embuc.Task

class Task34:Task {
	//Precompute factorials
	private val factorials = intArrayOf(1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880)

	override fun solve(): Any {
		var sum = 0
		//n*9! < 10^n Therefore, the upper limit is 10^7, but in reality it is much lower (<50_000)
		for (i in 3..50_000) {
			if (factorialDigitSum(i) == i) {
				sum += i
			}
		}
		return sum
	}

	private fun factorialDigitSum(x: Int): Int {
		var num = x
		var sum = 0
		while (num != 0) {
			sum += factorials[num % 10]
			num /= 10
		}
		return sum
	}
}