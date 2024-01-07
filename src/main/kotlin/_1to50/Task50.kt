package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.getPrimesBelow

// Consecutive prime sum
class Task50 : Task {
	override fun solve(): Any {
		val (primes, sieve) = getPrimesBelow(1000000)
		var max = 0
		var maxPrime = 0
		var maxPrimesToCheck = 0
		var sum = 0;
		for (i in primes.indices) {
			sum += primes[i]
			maxPrimesToCheck++
			if (sum >= 1000000) {
				break
			}
		}
		for (i in primes.indices) {
			var sum = 0
			var count = 0
			if(maxPrimesToCheck < count) {
				break
			}
			maxPrimesToCheck--;
			for (j in i until primes.size) {
				sum += primes[j]
				count++
				if (sum >= 1000000) {
					break
				}
				if (count < max) {
					continue
				}
				if (sieve[sum]) {
					max = count
					maxPrime = sum
				}
			}
		}
		return maxPrime
	}
}