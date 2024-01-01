package se.embuc._1to50

import se.embuc.Task

// Coin sums
//The coins array represents the available denominations.
//The wayToMakeAmount array is used for dynamic programming. waysToMakeAmount[amount][coinIndex] represents the number
//of ways to make change for the amount 'amount' using the first coinIndex+1 denominations. The dp array is initialized
//such that the first row is filled with 1s, as there's exactly one way to make change for 0 amount. The nested loops
//fill the dp array based on the recurrence relation: The number of ways to make change for amount  using coinIndex+1
//denominations is the sum of the ways to make change without using the coinIndex+1th denomination
//(waysToMakeAmount[amount][coinIndex-1]) and the ways to make change using at least one coinIndex+1th denomination
//(waysToMakeAmount[amount - coins[coinIndex]][coinIndex]). Finally, waysToMakeAmount[200][7] gives the number of ways
//to make change for 200 using all available denominations.
class Task31(private val coins: IntArray, private val amount: Int) : Task {
	override fun solve(): Any {
		val waysToMakeAmount = Array(amount + 1) { IntArray(coins.size) }

		// Initialize ways to make amount 0 with any set of coins as 1 (using no coins)
		for (coinIndex in coins.indices) {
			waysToMakeAmount[0][coinIndex] = 1
		}

		// Calculate the number of ways to make each amount
		for (amount in 1..amount) {
			for (coinIndex in coins.indices) {
				val waysWithoutCurrentCoin = if (coinIndex > 0) waysToMakeAmount[amount][coinIndex - 1] else 0
				val remainingAmount = amount - coins[coinIndex]
				val waysWithCurrentCoin = if (remainingAmount >= 0) waysToMakeAmount[remainingAmount][coinIndex] else 0

				waysToMakeAmount[amount][coinIndex] = waysWithoutCurrentCoin + waysWithCurrentCoin
			}
		}

//		for (i in 0..amount) {
//			println("amount: $i")
//			for (j in 0..coins.lastIndex) {
//				print("${waysToMakeAmount[i][j]} ")
//			}
//			println()
//		}
		// Total number of ways to make the target amount using all coin denominations
		return waysToMakeAmount[amount][coins.lastIndex]
	}
}