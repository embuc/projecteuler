package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.isPalindrome

// Double-base palindromes
// This can be sped up by checking arrays instead of strings
class Task36 :Task {
	override fun solve(): Any {
		var sum = 0;
		for (i in 1..1_000_000 step 2) {
			if (isPalindrome(i) && isPalindrome(i.toString(2))) {
				sum += i
			}
		}
		return sum
	}
}
