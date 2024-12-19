package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.digitsCount

// Cubic permutations, https://projecteuler.net/problem=62
// The cube,(41043625, 345^3), can be permuted to produce two other cubes:
// (384^3) and (405^3). In fact, 41043625 is the smallest cube which has exactly three permutations of its digits which
// are also cube.
// Find the smallest cube for which exactly five permutations of its digits are cube.
class Task62 : Task {
	override fun solve(): Any {
		val upper_limit = 100_000L
		val groupes = mutableMapOf<Int, MutableList<Long>>()
		for (i in 300..upper_limit) {
			val cube = i * i * i
			val digitsCount = cube.digitsCount()
			val digitsHash = digitsCount.contentHashCode()
			groupes.computeIfAbsent(digitsHash, {_ -> ArrayList<Long>()}).add(cube)
			if(groupes[digitsHash]!!.size == 5) {
				return groupes[digitsHash]!!.min()
			}
		}
		return -1
	}

}