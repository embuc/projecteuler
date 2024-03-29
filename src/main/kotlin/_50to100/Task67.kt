package se.embuc._50to100

import se.embuc.Task

// Maximum path sum II
class Task67(var input: String): Task {
	override fun solve(): Any {
		input.lines().map { it.split(" ").map { it.toInt() } }.let { triangle ->
			val dp = triangle.map { it.toMutableList() }
			// start to next to last row and work up
			for (i in dp.size - 2 downTo 0) {
				for (j in 0 until dp[i].size) {
					dp[i][j] += maxOf(dp[i + 1][j], dp[i + 1][j + 1])
				}
			}
			return dp[0][0]
		}
	}

}