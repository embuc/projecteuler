package se.embuc._1to50

import se.embuc.Task

// Coin sums
class Task31: Task {
	override fun solve(): Any {
		val coins = listOf(1, 2, 5, 10, 20, 50, 100)
		val target = 200
		var combinations = 1 //count in 200p (£2) coin
		for (a in 0..target / coins[6]) {
			for (b in 0..target / coins[5]) {
				for (c in 0..target / coins[4]) {
					for (d in 0..target / coins[3]) {
						for (e in 0..target / coins[2]) {
							for (f in 0..target / coins[1]) {
								for (g in 0..target / coins[0]) {
									if (a * coins[6] + b * coins[5] + c * coins[4] + d * coins[3] + e * coins[2] + f * coins[1] + g * coins[0] == target) {
										combinations++
									}
								}
							}
						}
					}
				}
			}
		}
		return combinations
	}
}