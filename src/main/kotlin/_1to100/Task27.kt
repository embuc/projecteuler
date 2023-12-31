package se.embuc._1to100

import se.embuc.Task
import se.embuc.utils.isPrime

// Quadratic Primes
class Task27:Task {
	override fun solve(): Any {
		var max = 0L
		var maxA = 0L
		var maxB = 0L
		for (a in -999..999) {
			for (b in -1000..1000) {
				var n = 0L
				while (isPrime(n * n + a * n + b)) {
					n++
					if(n > max){
						max = n
						maxA = a.toLong()
						maxB = b.toLong()
					}
				}
			}
		}
		println("max: $max maxA: $maxA maxB: $maxB" )
		return maxA * maxB
	}
}