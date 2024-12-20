package se.embuc._50to100

import se.embuc.Task

//Right Triangles with Integer Coordinates
class Task91(val input: Int) :Task {

	override fun solve(): Any {
		var numberOfRightTriangles = 0

		for (x2 in 0..input) {
			for (y2 in 0..input) {
				for (x3 in x2..input) {
					for (y3 in if ((x3 == x2)) (y2 + 1)..input else 0..input) {
						if (isRightTriangle(x2, y2, x3, y3)) {
							numberOfRightTriangles++
						}
					}
				}
			}
		}
		return numberOfRightTriangles
	}

	private fun isRightTriangle(x2: Int, y2: Int, x3: Int, y3: Int): Boolean {
		if ((x2 == 0 && y2 == 0) || (x3 == 0 && y3 == 0)) return false
		if (x2 == x3 && y2 == y3) return false

		val a = x2 * x2 + y2 * y2
		val b = x3 * x3 + y3 * y3
		val c = (x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3)
		return a + b == c || a + c == b || b + c == a
	}
}