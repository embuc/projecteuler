package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.isPanDigit

// Pandigital Multiples
class Task38:Task {

	override fun solve(): Any {
		var max = 0;
		for (i in 2..10000){
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