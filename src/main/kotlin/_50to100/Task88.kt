package se.embuc._50to100

import se.embuc.Task
/* Product-sum Numbers */
class Task88:Task {

	override fun solve(): Any {
		//	What is the sum of all the minimal product-sum numbers for 2 <= k <= 12000?
		return minimalProductSumNumbersDP(12000)
	}

	fun minimalProductSumNumbersDP(maxK: Int): Int {
		val dp = IntArray(maxK + 1) { Int.MAX_VALUE } // DP table to store minimal product-sum numbers
		dp[0] = 0 // Base case (not used, but avoids indexing issues)

		// Explore all combinations of numbers
		fun compute(product: Int, sum: Int, numTerms: Int, start: Int) {
			val size = numTerms + (product - sum) // Calculate the effective size (including implicit 1s)

			// If size exceeds maxK, stop exploring
			if (size > maxK) return

			// Update the DP table for this size
			dp[size] = minOf(dp[size], product)

			// Recursively try adding more numbers
			for (i in start..2 * maxK) {
				// Avoid overflows by stopping early
				if (product * i > 2 * maxK) break
				compute(product * i, sum + i, numTerms + 1, i)
			}
		}

		// Start from an empty combination and explore all possibilities
		compute(1, 0, 0, 2)

		// Return the sum of all unique minimal product-sum numbers
		return dp.slice(2..maxK).toSet().sum() // Slice for k=2 to maxK and sum distinct values
	}

	// this is backtracking solution works nice for low K:s
	fun minimalProductSumNumberRange(k: Int): Int {
		val uniqueNs = mutableSetOf<Int>()
		return (2..k)
			// Use range into a sequence for lazy evaluation, computations are performed
			// one at a time instead of creating large intermediate collections.
			.asSequence()
			.map { minimalProductSumNumber(it) }
			.filter { uniqueNs.add(it) } // set returns true only if adding new(unique) element
			.sum()
	}

	fun minimalProductSumNumber(k: Int,
		current: MutableList<Int> = mutableListOf(), // Current combination
		smallestN: Int = Int.MAX_VALUE // Tracks the smallest N during recursion
	): Int {
		val sum = current.sum()
		val product = current.fold(1) { acc, i -> acc * i }

		val size = current.size + (product - sum)

		// Base case: If we've reached exactly k terms and the product-sum condition is satisfied
		if (size == k && product >= sum) {
			val n = product
//			println("Found: $current -> Product-Sum: $n for k: $k")
			return minOf(smallestN, n) // Return the smallest N so far
		}

		// Stop recursion if the size exceeds k
		if (size > k) return smallestN

		// Backtracking: Explore numbers starting from the last number in `current` or 2
		val start = if (current.isEmpty()) 2 else current.last()
		var minN = smallestN
		for (i in start..2 * k) { // 2 * k is an arbitrary limit to avoid excessively large numbers
			current.add(i)
			minN = minOf(minN, minimalProductSumNumber(k, current, minN))
			current.removeAt(current.size - 1) // Backtrack
		}

		return minN
	}

}

