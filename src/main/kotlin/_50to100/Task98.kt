package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.readFileAsString

// Anagramic Squares
class Task98 : Task {
	override fun solve(): Any {
		val words = readFileAsString("0098_words.txt").split(",").map { it.replace("\"", "") }
		val anagrams = words.groupBy { it.toCharArray().sorted().joinToString("") }
			.filter { it.value.size > 1 }
			.values.toList()

//		println("Found ${anagrams.size} anagram groups")
		var maxSquare = 0L

		// Cache squares by length
		val squaresByLength = mutableMapOf<Int, List<Long>>()

		for (group in anagrams) {
			val wordLength = group.first().length

			// Get or compute squares for this length
			val squares = squaresByLength.getOrPut(wordLength) {
				val start = Math.pow(10.0, (wordLength - 1).toDouble()).toLong()
				val end = Math.pow(10.0, wordLength.toDouble()).toLong() - 1
				generateSequence(Math.sqrt(start.toDouble()).toLong()) { it + 1 }
					.map { it * it }
					.takeWhile { it <= end }
					.filter { it.toString().length == wordLength }  // Extra safety check
					.toList()
			}

			// Check all pairs in group
			for (i in group.indices) {
				for (j in i + 1 until group.size) {
					maxSquare = maxOf(maxSquare, findLargestSquare(group[i], group[j], squares))
				}
			}
		}

		return maxSquare
	}

	private fun findLargestSquare(word1: String, word2: String, squares: List<Long>): Long {
		if (word1.length != word2.length) return 0  // Safety check
		var largest = 0L

		for (square in squares) {
			val squareStr = square.toString()
			if (squareStr[0] == '0' || squareStr.length != word1.length) continue

			val mapping = tryCreateMapping(word1, squareStr) ?: continue
			val mapped = mapWordToNumber(word2, mapping) ?: continue

			if (mapped.toString()[0] != '0' && squares.contains(mapped)) {
//				println("Match: $word1 ($square) -> $word2 ($mapped)")
				largest = maxOf(largest, square, mapped)
			}
		}

		return largest
	}

	private fun tryCreateMapping(word: String, number: String): Map<Char, Char>? {
		if (word.length != number.length) return null  // Length check

		val mapping = mutableMapOf<Char, Char>()
		val usedDigits = mutableSetOf<Char>()

		for (i in word.indices) {
			val letter = word[i]
			val digit = number[i]

			if (letter in mapping) {
				if (mapping[letter] != digit) return null
			} else {
				if (digit in usedDigits) return null
				mapping[letter] = digit
				usedDigits.add(digit)
			}
		}
		return mapping
	}

	private fun mapWordToNumber(word: String, mapping: Map<Char, Char>): Long? {
		return try {
			word.map { mapping[it] }.joinToString("").toLong()
		} catch (e: NumberFormatException) {
			null
		}
	}
}
