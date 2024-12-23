package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.gcd
import kotlin.math.sqrt

//Almost Equilateral Triangles
class Task94 : Task {

// Two isosceles triangle types: (a, a, a-1) or (a, a, a+1).
// Conditions:
//    - 'a' is an integer.
//    - Area (Heron's formula) is an integer.
//    - Perimeter (3a - 1 or 3a + 1) <= 1,000,000,000.
//
// Type 2 (a, a, a+1) analysis:
//   - Area simplifies to A = (a+1)/4 * sqrt(3a^2 - 2a - 1).
//   - A is integer if:
//        - (a+1) is a multiple of 4 (a+1 = 4x).
//        - 3a^2 - 2a - 1 is a perfect square.
//   - This reduces to Pell-type equation: x^2 - 3y^2 = 1.
//   - Recurrence for Type 2 'a' values: a_(n+1) = 14 * a_n - a_(n-1) + 4.
//   - Valid starting 'a' values: 5, 70, 979.
//
//Perimeters:
//   - Type 1 (a,a,a-1) perimeter: 3a-1.
//   - Type 2 (a,a,a+1) perimeter: 3a+1.

	override fun solve(): Any {
		val limit = 1_000_000_000
		var sum = 0L

		for (s in 1..sqrt((limit + 1.0) / 3.0).toInt() step 2) {
			for (t in (s - 2) downTo 1 step 2) {
				if(gcd(s,t) == 1){
					val a = s * t
					val b = (s * s - t * t) / 2
					val c = (s * s + t * t) / 2

					if (a * 2 == c - 1) {
						val p = c * 3 - 1
						if (p <= limit) sum += p
					}
					if (a * 2 == c + 1) {
						val p = c * 3 + 1
						if (p <= limit) sum += p
					}

					if (b * 2 == c - 1) {
						val p = c * 3 - 1
						if (p <= limit) sum += p
					}
					if (b * 2 == c + 1) {
						val p = c * 3 + 1
						if (p <= limit) sum += p
					}
				}
			}
		}
		return sum
	}
}