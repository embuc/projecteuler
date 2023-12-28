package se.embuc._1to100

import se.embuc.Task
import se.embuc.utils.sumOfPrimesBelow

/**
 * https://projecteuler.net/problem=10
 * Summation of primes
 * Created by embuc on 2023-12-27.
 */
class Task10: Task {

	override fun solve(): Any {
		return sumOfPrimesBelow(2_000_000)
	}

}