package se.embuc._50to100

import se.embuc.Task

//Amicable Chains
class Task95:Task {

	override fun solve(): Int {
		val limit = 1_000_000
		val divisorSums = IntArray(limit) { 0 } // IntArray is efficient for primitive ints

		// divisor sums (sieve method)
		for (i in 1 until limit) {
			for (j in 2 * i until limit step i) {
				divisorSums[j] += i
			}
		}

		val chainLengths = IntArray(limit) { 0 } // Initialize with 0 (untested), -1 (bad), n (chain length)
		chainLengths[0] = -1

		for (i in 1 until limit) {
			if (chainLengths[i] != 0) continue // Skip if already processed

			val sequence = mutableListOf(i)
			var current = i

			// Build the sequence while still under the limit, not already visited, and not in loop
			while (true) {
				val next = divisorSums[current]
				if(next >= limit || chainLengths[next] != 0 || sequence.contains(next))
					break;
				current = next
				sequence.add(current)
			}

			val lastDivisorSum = divisorSums[sequence.last()]
			if (lastDivisorSum in sequence) { // Loop detected!
				val loopStart = sequence.indexOf(lastDivisorSum)

				// Mark within-loop numbers with the chain length
				for (k in loopStart until sequence.size) {
					chainLengths[sequence[k]] = sequence.size - loopStart
				}
			} else { // Sequence is bad, exceeded limit or reached a bad number
				for (s in sequence) {
					chainLengths[s] = -1
				}
			}
		}

		return chainLengths.indexOf(chainLengths.maxOrNull() ?: -1)
	}
}