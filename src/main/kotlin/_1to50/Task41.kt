package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.isPrime
import se.embuc.utils.permutations

// Pandigital prime
// 9-digits is a no-go (1+2+3+4+5+6+7+8+9=45 => always dividable by 3)
// 8-digits cannot be done (1+2+3+4+5+6+7+8=36 => always dividable by 3)
// 6-digits cannot be done (1+2+3+4+5+6=21 => always dividable by 3)
// 5-digits cannot be done (1+2+3+4+5=15 => always dividable by 3)
// and to be pan, it has to have for 1 to n digits, so 7 digits it is
class Task41 : Task {
	override fun solve(): Any {
		val permutations = "7654321".permutations().sortedDescending();
		for (i in permutations) {
			if (isPrime(i.toLong())) {
				return i
			}
		}
		return -1
	}
}