package se.embuc

//Longest Collatz Sequence
class Task14 : Task {

	private val maxNumber = 1_000_000
	private val cache = LongArray(maxNumber) { 0 }

	override fun solve(): Any {
		var maxLength = 0L
		var number = 0L

		for (i in 1 until 1_000_000) {
			val length = findColatzSeqLength(i.toLong())
			if (length > maxLength) {
				maxLength = length
				number = i.toLong()
			}
		}
		return number
	}

	fun findColatzSeqLength(n: Long): Long {
		if (n < maxNumber && cache[n.toInt()] != 0L) {
			return cache[n.toInt()]
		}

		val next = if (n % 2 == 0L) n /2 else 3 * n + 1
		val length = if (n != 1L) 1 + findColatzSeqLength(next) else 1
		if (n < maxNumber) {
			cache[n.toInt()] = length
		}

		return length
	}
}