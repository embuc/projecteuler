package se.embuc._50to100

import se.embuc.Task

// Coin Partitions
class Task78 : Task{
	override fun solve(): Int {
		val TARGET_MOD = 1_000_000
		val WAYS_SIZE = 100_000 //guessed size
		val ways = LongArray(WAYS_SIZE) { 0 }
		ways[0] = 1 // Base case

		var n = 1 // Start from the first natural number
		while (n < WAYS_SIZE) {
			var partitionSum = 0L
			var k = 1
			while (true) {
				val pentagonal1 = k * (3 * k - 1) / 2
				val pentagonal2 = k * (3 * k + 1) / 2

				// Break the loop if the first pentagonal number is greater than n
				if (pentagonal1 > n) break

				// Add or subtract partitions based on the generalized pentagonal number theorem
				if (pentagonal1 <= n) {
					partitionSum = (partitionSum + (if ((k - 1) % 2 == 0) 1 else -1) * ways[n - pentagonal1] + TARGET_MOD) % TARGET_MOD
				}
				if (pentagonal2 <= n) {
					partitionSum = (partitionSum + (if ((k - 1) % 2 == 0) 1 else -1) * ways[n - pentagonal2] + TARGET_MOD) % TARGET_MOD
				}

				k++
			}

			ways[n] = partitionSum
			if (partitionSum % TARGET_MOD == 0L) {
				return n // Return n if the partition sum is divisible by 1 million
			}
			n++
		}
		return -1
	}
}