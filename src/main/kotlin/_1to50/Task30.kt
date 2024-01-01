package se.embuc._1to50

import se.embuc.Task

// Digit fifth powers
// Stream version was too slow, arrays to the rescue
class Task30: Task {
	override fun solve(): Any {
		var sum = 0
		for (i in 2..195_000) {
			val charArray = i.toString().toCharArray();
			var localSum = 0
			for (j in 0 until charArray.size) {
				val digit = charArray[j] - '0'
				localSum += digit * digit * digit * digit * digit
			}
			if (i == localSum) {
				sum += i
			}
		}
		return sum
	}

}