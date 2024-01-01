package se.embuc._1to50

import se.embuc.Task

//Large Sum
class Task13(private val input: String) : Task {

	override fun solve(): Any {
		return  input.split("\n").map { it.toBigInteger() }.reduce{acc, j -> acc.plus(j) } .toString().substring(0, 10)
	}
}