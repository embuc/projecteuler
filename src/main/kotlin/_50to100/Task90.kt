package se.embuc._50to100

import se.embuc.Task
//Cube Digit Pairs
class Task90:Task {

	override fun solve(): Any {
		val squarePairs = listOf(
			Pair(0, 1), Pair(0, 4), Pair(0, 9),
			Pair(1, 6), Pair(2, 5), Pair(3, 6),
			Pair(4, 9), Pair(6, 4), Pair(8, 1)
		)
		// Function to check if a die can represent a digit (considering 6 ↔ 9)
		fun canRepresent(die: Set<Int>, digit: Int): Boolean {
			return digit in die || (digit == 6 && 9 in die) || (digit == 9 && 6 in die)
		}
		// Step 2: Generate all combinations of 6 digits for a die
		val allDice = combinations((0..9).toList(), 6).map { it.toSet() }

		// Step 3: Check all pairs of dice
		var count = 0
		for (i in allDice.indices) {
			for (j in i until allDice.size) {
				val die1 = allDice[i]
				val die2 = allDice[j]

				// Check if the pair can represent all square numbers
				if (squarePairs.all { (a, b) ->
						(canRepresent(die1, a) && canRepresent(die2, b)) ||
								(canRepresent(die1, b) && canRepresent(die2, a))
					}) {
					count++
				}
			}
		}

		return count
	}

	private fun <T> combinations(list: List<T>, k: Int): List<List<T>> {
		if (k == 0) return listOf(emptyList())
		if (list.isEmpty()) return emptyList()
		val head = list.first()
		val tail = list.drop(1)
		val withHead = combinations(tail, k - 1).map { it + head }
		val withoutHead = combinations(tail, k)
		return withHead + withoutHead
	}
}