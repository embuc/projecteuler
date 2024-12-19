package se.embuc._1to50

import se.embuc.Task

// Double-base palindromes
// This can be sped up by checking arrays instead of strings
class Task36 :Task {
	override fun solve(): Any {
		var sum = 0
		for (i in 1..1_000_000 step 2) {
//			if (isPalindrome(i) && isPalindrome(i.toString(2))) {
//				sum += i
//			}
			sum += check(i)
		}
		return sum
	}

	fun isDecimalPalindrome(number: Int): Boolean {
		var reversed = 0
		var temp = number
		while (temp > 0) {
			reversed = reversed * 10 + temp % 10
			temp /= 10
		}
		return number == reversed
	}

	fun isBinaryPalindrome(number: Int): Boolean {
		var reversed = 0
		var temp = number
		while (temp > 0) {
			reversed = (reversed shl 1) or (temp and 1)
			temp = temp ushr 1
		}
		return number == reversed
	}

	fun check(number: Int): Int {
		if (isDecimalPalindrome(number) && isBinaryPalindrome(number)) {
			return number
		}
		return 0
	}
}
