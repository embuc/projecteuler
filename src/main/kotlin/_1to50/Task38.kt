package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.isPanDigit

// Pandigital Multiples
// Optimization: The number to beat is 918273645. This means that our "starting number" (like 192 in the example) should
// begin with a 9.
// Observe: 9[0-9] will have too few or too many digits (8 or 11)
// Observe: 9[0-9][0-9] will have too few or too many digits (7 or 11)
// Observe: larger than 100000 won't work, too few or too many digits.
//
// Conclusion:
// The candidate starting number must be in the 9[0-9][0-9][0-9] series.
// In particular, it must be in the > 9182 (see example value)
// Further: we are looking for 4-digit number times 1 and 2.  A 3-digit number starting with 9 would produce 7 or 11
// digits, and a 2-digit number starting with 9 would produce 8 or 11 digits.  So a 4-digit number it is, and since we
// are only concerned with the max, we can start from 9876 and work backwards.
class Task38:Task {

	override fun solve(): Any {
		for (i in 9876 downTo 9183 step 1){
			var number = ""
			var j = 1
			var products = mutableListOf<Int>()
			while (number.length < 9){
				number += (i * j).toString()
				products.add(i * j)
				j++
			}
			if (number.length == 9 && isPanDigit(products.toIntArray())){
				return number
			}
		}
		return -1
	}
}