package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.isPanDigit

// Pandigital Multiples
// Optimization: The number to beat is 918273645. This means that our "starting number" (like 192 in the example) should
// begin with a 9.
// Observe: 9[0-9] will have too few or too many digits (8 or 11)
// Observe: 9[0-9][0-9] wiil have too few or too many digits (7 or 11)
// Observe: larger than 100000 won't work, too few or too many digits.
//
// Conclusion:
// The candidate starting number must be in the 9[0-9][0-9][0-9] series.
// In particular, it must be in the > 9182 (see example value)
class Task38:Task {

	override fun solve(): Any {
		var max = 0;
		for (i in 9183..9876){
			var number = ""
			var j = 1
			var products = mutableListOf<Int>()
			while (number.length < 9){
				number += (i * j).toString()
				products.add(i * j)
				j++
			}
			if (number.length == 9 && isPanDigit(products.toIntArray())){
				val intNumber = number.toInt()
				if(intNumber > max){
					max = intNumber
				}
			}
		}
		return max
	}
}