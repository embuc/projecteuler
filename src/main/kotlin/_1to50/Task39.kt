package se.embuc._1to50

import se.embuc.Task

/**
 * Integer right triangles
 * We know that a+b>c, otherwise the edges would not join to form a triangle. Adding c to both sides gives, a+b+c>2c,
 * and as a+b+c<=1000, 2c<=1000, hence c<=500. Because c is the longest side, a<500, so it is only necessary for the
 * loop to run so far.
 * Further, With a,b,c the triangle sides, we have
 * a+b+c == p
 * a^2 + b^2 == c^2
 *
 * Combining these, we get
 * b = (p^2 - 2(p*a)) / 2(p-a)
 * Thus if (p^2 - 2(p*a)) % 2(p-a) == 0 we have a solution
 *
 */
class Task39 : Task {
	override fun solve(): Any {
		var maxSolutions = 0
		var perimeter = 0
		for (p in 3 until 1000) {
			var solutions = 0
			for (a in 2..(p / 3)) {
				if ((p * p - 2 * p * a) % (2 * p - 2 * a) == 0) {
					solutions += 1
				}
			}
			if (solutions > maxSolutions) {
				maxSolutions = solutions
				perimeter = p
			}
		}
		return perimeter
	}

}