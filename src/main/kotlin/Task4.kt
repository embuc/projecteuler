package se.embuc

import se.embuc.utils.isPalindrome

/* Largest Palindrome Product */
class Task4: Task {

	override fun solve(): Any {
		var largest = 0
		for (i in 100..999) {
			for (j in 100..999) {
				val product = i * j
				if (isPalindrome(product) && product > largest) {
					largest = product
				}
			}
		}
		return largest
	}
}