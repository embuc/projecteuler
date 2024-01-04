package se.embuc._1to50

import se.embuc.Task

// Champernowne's constant
class Task40: Task {
	override fun solve(): Any {
		var s = ""
		var i = 1
		while (s.length < 1_000_000) {
			s += i++
		}
		return s[0].toString().toInt() * s[9].toString().toInt() * s[99].toString().toInt() * s[999].toString().toInt() * s[9999].toString().toInt() * s[99999].toString().toInt() * s[999999].toString().toInt()
	}
}