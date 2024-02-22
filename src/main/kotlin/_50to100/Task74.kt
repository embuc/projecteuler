package se.embuc._50to100

import se.embuc.Task

// Digit factorial chains
class Task74: Task {

	private val factorialDigits = intArrayOf(1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880)
	private val chainLengths = IntArray(3000000) // Stores the length of the factorial chain for each number
	private var countOfChainsWithLengthSixty = 0

	private fun sumOfFactorialDigits(number: Int): Int {
		if (number == 0) {
			return 0
		}
		return factorialDigits[number % 10] + sumOfFactorialDigits(number / 10)
	}

	private fun calculateChainLength(number: Int): Int {
		if (chainLengths[number] != 0) {
			return chainLengths[number]
		}
		// Initially mark the number as visited to prevent infinite recursion
		chainLengths[number] = 1 // Temporarily set to 1 to mark as visited
		chainLengths[number] = 1 + calculateChainLength(sumOfFactorialDigits(number))
		return chainLengths[number]
	}

	override fun solve(): Any {
		// Predefined chain lengths based on the problem's statement
		// These specific values are pre-calculated lengths according to the problem's unique cases.
		chainLengths[169] = 3
		chainLengths[871] = 2
		chainLengths[872] = 2
		chainLengths[40585] = 1
		chainLengths[145] = 1
		chainLengths[45361] = 2
		chainLengths[45362] = 2

		for (number in 1..1000000 - 1) {
			if (calculateChainLength(number) == 60) {
				countOfChainsWithLengthSixty++
			}
		}

		return countOfChainsWithLengthSixty
	}
}