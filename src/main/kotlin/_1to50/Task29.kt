package se.embuc._1to50

import se.embuc.Task
import java.math.BigInteger

// Distinct powers
class Task29:Task {
	override fun solve(): Any {
		val seq = mutableSetOf<BigInteger>()
		for(a in 2..100) {
			for (b in 2..100) {
				seq.add(BigInteger.valueOf(a.toLong()).pow(b))
			}
		}
		return seq.size
	}
}