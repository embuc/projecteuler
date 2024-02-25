package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.digitsSum
import se.embuc.utils.hasNonZeroDecimalDigits
import se.embuc.utils.sqrt
import java.math.BigDecimal

// Square Root Digital Expansion
class Task80 : Task {
	override fun solve(): Any {
		return sumOfDecimalParts((2..99).map { sqrt(it.toBigDecimal(), 101) })
	}

	fun sumOfDecimalParts(numbers: List<BigDecimal>): Int {
		return numbers.fold(0) { sum, number ->
			if(number.hasNonZeroDecimalDigits()) {
				sum + number.digitsSum()
			} else {
				sum
			}
		}
	}
}



