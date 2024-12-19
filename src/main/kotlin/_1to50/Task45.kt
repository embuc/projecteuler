package se.embuc._1to50

import se.embuc.Task
import se.embuc.utils.findPositiveIntegerRoot
import se.embuc.utils.getTriangleNumber

// Triangular, pentagonal, and hexagonal
// Tn = n(n+1)/2
// Pn = n(3n-1)/2
// Hn = n(2n-1)
class Task45 : Task {
	override fun solve(): Any {
		var n = 286L
		while (true) {
			val triangle = getTriangleNumber(n++)
			findPositiveIntegerRoot(3 / 2.0, -1 / 2.0, -triangle.toDouble())?.let {
				findPositiveIntegerRoot(2.0, -1.0, -triangle.toDouble())?.let {
					return triangle
				}
			}
		}
	}
}