package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.readFileAsString

//Path Sum: Three Ways
class Task82 : Task {
	override fun solve(): Any {
		val map = readFileAsString("82_matrix.txt")
			.lines()
			.map { it.split(",").map { it.toInt() }.toTypedArray() }
			.toTypedArray()

		return findMinimumPathSum(map)
	}

	fun findMinimumPathSum(matrix: Array<Array<Int>>): Int {
		val rows = matrix.size
		val cols = matrix[0].size

		// The dp table holds the minimum path sums. Initialize it with the starting matrix values.
		val dp = Array(rows) { row -> IntArray(cols) { col -> matrix[row][col] } }

		for (col in cols - 2 downTo 0) {
			// First: Initialize with right neighbor
			for (row in 0 until rows) {
				dp[row][col] += dp[row][col + 1]
			}

			// Second: Scan upwards, update if we find a shorter path
			for (row in 1 until rows) {
				dp[row][col] = minOf(dp[row][col], dp[row - 1][col] + matrix[row][col])
			}

			// Third: ...and then downwards
			for (row in rows - 2 downTo 0) {
				dp[row][col] = minOf(dp[row][col], dp[row + 1][col] + matrix[row][col])
			}
		}

		// Find the minimum path sum in the leftmost column
		return dp.minOf { it[0] }
	}
}