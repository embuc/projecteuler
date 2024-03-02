package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.readFileAsString

//Path Sum: Two Ways
class Task81:Task {
	override fun solve(): Any {
		val map = readFileAsString("81_matrix.txt")
			.lines()
			.map { it.split(",").map { it.toInt() }.toTypedArray() }
			.toTypedArray()
		for (i in 0 until map.size) {
			for (j in 0 until map[i].size) {
				if (i == 0 && j == 0) continue
				if (i == 0) {
					map[i][j] += map[i][j - 1]
					continue
				}
				if (j == 0) {
					map[i][j] += map[i - 1][j]
					continue
				}
				map[i][j] += minOf(map[i - 1][j], map[i][j - 1])
			}
		}

		return map.last().last()
	}
}