package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.isPermutation
import se.embuc.utils.isPrime

// Prime permutations
class Task49 : Task {
	override fun solve(): Any {
		for (i in 1000..9999) {
			if (i == 1487) continue
			val j = i + 3330
			val k = j + 3330
			if (isPermutation(i, j) && isPermutation(j, k) && isPrime(i) && isPrime(j) && isPrime(k)) {
				return "$i$j$k"
			}
		}
		return -1
	}

}