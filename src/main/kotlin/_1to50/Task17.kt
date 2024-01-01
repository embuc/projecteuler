package se.embuc._1to50

import se.embuc.Task

// Number letter counts
class Task17:Task {

	override fun solve(): Any {
		var sum = 0
		for (i in 1..1000) {
			sum += toEnglish(i).length
		}
		return sum
	}

	/* no spaces between words */
	private fun toEnglish(i: Int): String {
		if (i == 1000) return "onethousand"

		val belowTwenty = arrayOf(
			"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
		)
		val tens = arrayOf(
			"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
		)

		return when {
			i >= 100 -> "${belowTwenty[i / 100]}hundred${if (i % 100 > 0) "and${toEnglish(i % 100)}" else ""}"
			i >= 20 -> "${tens[i / 10]}${if (i % 10 > 0) "${belowTwenty[i % 10]}" else ""}"
			else -> belowTwenty[i]
		}
	}
}