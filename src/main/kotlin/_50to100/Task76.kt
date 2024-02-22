package se.embuc._50to100

import se.embuc.Task

// Counting summations
class Task76:Task {
	override fun solve(): Any {
		val n = 100
		val ways = IntArray(n + 1)
		ways[0] = 1
		for (i in 1 until n) {
			for (j in i..n) {
				ways[j] += ways[j - i]
			}
		}
		return ways[n]
	}
}