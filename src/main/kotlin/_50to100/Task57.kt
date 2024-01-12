package se.embuc._50to100

import se.embuc.Task
import java.math.BigInteger

//Square root convergents
class Task57 : Task {
	override fun solve(): Any {
		val big2 = BigInteger.valueOf(2)
		var n= BigInteger.valueOf(3)
		var d= BigInteger.valueOf(2)
		var count = 0

		for(i in 2..1000) {
			val n2 = n + d.multiply(big2)
			val d2 = n + d
			if(n2.toString().length > d2.toString().length) {
				count++
			}
			n = n2
			d = d2
		}
		return count
	}
}