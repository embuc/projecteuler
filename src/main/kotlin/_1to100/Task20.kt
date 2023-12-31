package se.embuc._1to100

import se.embuc.Task
import se.embuc.utils.factorialBig

// Factorial Digit Sum
class Task20(private val n:Int):Task {

	override fun solve(): Any {
		return factorialBig(n).toString().map { it.toString().toInt() }.sum()
	}
}