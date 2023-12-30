package se.embuc._1to100

import se.embuc.Task

// Largest product in a grid
class Task11(val input: String) : Task {

	override fun solve(): Any {
		val grid = input.split("\n").map { it.split(" ").map { it.toInt() } }
		var max = 0
		for (i in 0 until grid.size) {
			for (j in 0 until grid[i].size - 3) {
				val product = grid[i][j] * grid[i][j + 1] * grid[i][j + 2] * grid[i][j + 3]
				if (product > max) {
					max = product
				}
			}
		}
		for (i in 0 until grid.size - 3) {
			for (j in 0 until grid[i].size) {
				val product = grid[i][j] * grid[i + 1][j] * grid[i + 2][j] * grid[i + 3][j]
				if (product > max) {
					max = product
				}
			}
		}
		for (i in 0 until grid.size - 3) {
			for (j in 0 until grid[i].size - 3) {
				val product = grid[i][j] * grid[i + 1][j + 1] * grid[i + 2][j + 2] * grid[i + 3][j + 3]
				if (product > max) {
					max = product
				}
			}
		}
		for (i in 0 until grid.size - 3) {
			for (j in 3 until grid[i].size - 3) {
				val product = grid[i][j] * grid[i + 1][j - 1] * grid[i + 2][j - 2] * grid[i + 3][j - 3]
				if (product > max) {
					max = product
				}
			}
		}
		return max
	}
}