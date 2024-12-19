package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.readFileAsString

//Roman Numerals
class Task89:Task {

	override fun solve(): Any {
		val big_input = readFileAsString("89.txt").split("\n").map { it.trim() }
	    val small_input = """
				MMMMDCLXXII
				MMDCCCLXXXIII
				MMMDLXVIIII
				MMMMDXCV
				""".trimIndent().split("\n").map { it.trim() }
		return convertRomanToMinimal(big_input)
//		return convertRomanToMinimal(small_input)
	}

	private fun convertRomanToMinimal(input: List<String>): Any {
		var saved = 0
		for (line in input) {
			var minimal = line
			minimal = minimal.replace("DCCCC", "CM")
			minimal = minimal.replace("CCCC", "CD")
			minimal = minimal.replace("LXXXX", "XC")
			minimal = minimal.replace("XXXX", "XL")
			minimal = minimal.replace("VIIII", "IX")
			minimal = minimal.replace("IIII", "IV")
			saved += line.length - minimal.length
		}
		return saved
	}
}