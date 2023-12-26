package se.embuc

/* Sum square difference */
class Task6: Task {
	override fun solve(): Any {
		return squareOfSum(100) - sumOfSquares(100)
	}

	private fun sumOfSquares(i: Long): Long {
		return (1..i).map { it * it }.sum()
	}

	private fun squareOfSum(i: Long): Long {
		(1..i).sum().let {
			return it * it
		}
	}
}