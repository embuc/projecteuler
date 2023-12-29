package se.embuc._1to100

import se.embuc.Task
// Maximum path sum I (dynamic programming is efficient here O(n2))
class Task18(private val input: List<String>) :Task {

	override fun solve(): Any {
		val triangle  = input.map { it.split(" ").map { it.toInt() } }
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