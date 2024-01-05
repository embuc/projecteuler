package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.getTriangleNumbersUpTo
import se.embuc.utils.readFileAsString

// Coded Triangle Numbers
// 1786 words, 14 letters max ASCII A is 65 (so we subtract 64 from each letter)
// total of 26 letters, max sum can be 14*26 = 364
class Task42 : Task {
	override fun solve(): Any {
		// build map of triangle numbers up to 364
		val triangleNumbers = getTriangleNumbersUpTo(364)
		return readFileAsString("42_words.txt").split(",")
			//.map { it.replace("\"", "") } // this is a bit slower
			.map { it.substring(1..(it.length-2)) }
			.map {
				// it.toCharArray().map { it.code - 64 }.sum() // this is a bit slower
				val arr = it.toCharArray()
				var sum = 0
				for (i in arr) {
					sum += i.code - 64
				}
				sum
			}
			.filter { triangleNumbers[it] }.count()
	}

}