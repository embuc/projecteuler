package se.embuc._1to50

import se.embuc.Task
import java.math.BigInteger

// Self powers
class Task48 : Task {
	override fun solve(): Any {
		var result = BigInteger.ONE
		for (i in 2..1000L){
			result+= BigInteger.valueOf(i).pow(i.toInt())
		}
		return result.toString().takeLast(10)
	}
}