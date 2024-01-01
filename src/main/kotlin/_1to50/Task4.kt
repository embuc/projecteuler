package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.isPalindrome

/* Largest Palindrome Product */
class Task4: Task {

	override fun solve(): Any {
		var largest = 0
		for (i in 999 downTo 100) {
			val max = findLargestPalindromeFor(i, largest)
			if (max > largest) {
				largest = max
			}
		}
		return largest
	}

	private fun findLargestPalindromeFor(i: Int, largest: Int): Int {
		for (j in i downTo 100) {
			val product = i * j
			if (product <= largest) {
				break
			}
			if (isPalindrome(product)) {
				return product
			}
		}
		return 0
	}
}