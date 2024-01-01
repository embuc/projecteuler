package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.getDivisorsSum

class Task23:Task {
	override fun solve(): Any {
		val limit = 28123
		val abundantNumbers = (1..limit).filter { getDivisorsSum(it) > it }
		var abundantSums = BooleanArray(limit + 1)
		for (i in abundantNumbers.indices) {
			for (j in i until abundantNumbers.size) {
				val sum = abundantNumbers[i] + abundantNumbers[j]
				if(sum > limit) break
				abundantSums[abundantNumbers[i] + abundantNumbers[j]] = true
			}
		}
		return  (1..limit).toList().filter { !abundantSums[it] }.sum()
	}

}