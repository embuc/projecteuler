package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.readFileAsString

//Largest Exponential
class Task99 : Task {

	override fun solve(): Any {
		val lines = readFileAsString("0099_base_exp.txt").lines()
		val max = lines.mapIndexed { index, s ->
			val (a, b) = s.split(",").map { it.toLong() }
			Pair(index + 1, b * Math.log(a.toDouble()))
		}.maxBy { it.second }!!
		return max.first
	}
}