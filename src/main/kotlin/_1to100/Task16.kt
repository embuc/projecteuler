package se.embuc._1to100

import se.embuc.Task
import java.math.BigInteger

// Power digit sum
class Task16:Task {
	override fun solve(): Any {
		return BigInteger.valueOf(2).pow(1000).toString().toCharArray().map { it.toString().toInt() }.sum()
	}
}