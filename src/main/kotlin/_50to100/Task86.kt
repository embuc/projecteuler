package se.embuc._50to100

import se.embuc.Task
import kotlin.math.sqrt

// Cuboid route
class Task86:Task {
	override fun solve(): Any {
		return calculateSolutions()
	}

	fun isResultInteger(x: Int, sumOfYAndZ: Int): Boolean {
		val result = sqrt((x * x + sumOfYAndZ * sumOfYAndZ).toDouble())
		return result == result.toLong().toDouble()
	}

	fun calculateSolutions(): Int {
		var solutionsCount: Long = 0
		var number: Int = 0

		while (solutionsCount <= 1000000) {
			number++
			for (sumOfYAndZ in 1..number + number) {
				if (isResultInteger(number, sumOfYAndZ)) {
					solutionsCount += if (sumOfYAndZ > number + 1) {
						(number + number + 2 - sumOfYAndZ) / 2
					} else {
						sumOfYAndZ / 2
					}
				}
			}
		}
		return number
	}
}