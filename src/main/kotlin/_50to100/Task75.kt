package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.gcd

// Singular integer right triangles
/*
 * Pythagorean Triples Characteristics Summary:
 *
 * 1. Primitive vs. Non-Primitive:
 *    - A Pythagorean triple (a, b, c) is primitive if a, b, and c are coprime (GCD = 1).
 *    - Non-primitive triples can be obtained by scaling a primitive triple by a common factor.
 *
 * 2. Generating Triples with Euclid's Formula:
 *    - Euclid's formula generates triples using two positive integers, m and n (m > n).
 *    - The triple is given by (a = m^2 - n^2, b = 2mn, c = m^2 + n^2).
 *    - This formula generates all primitive triples if m and n are coprime and not both odd.
 *    - By varying m and n, an infinite number of triples can be produced.
 *
 * 3. Examples:
 *    - The most well-known Pythagorean triple is (3, 4, 5).
 *    - Other examples include (5, 12, 13), (7, 24, 25), and (8, 15, 17).
 */
class Task75: Task {

	//Non-Primitive Triples
	fun generatePythagoreanTriples(limit: Int): Int {
		var arr = IntArray(1_500_001){ 0 }// track how many triangles we can form with a given perimeter
		for (m in 2..Math.sqrt(limit.toDouble()).toInt()) {
			for (n in 1 until m) {
				if ((m - n) % 2 == 1 && gcd(m, n) == 1) {
					var k = 1 // (re)Initialize multiplier
					while (true) {
						val a = k * (m * m - n * n)
						val b = k * (2 * m * n)
						val c = k * (m * m + n * n)
						if (a + b + c >= limit) break // Stop if the sum exceeds the limit
						val L = a+b+c
						arr[L]++
//						println("($a, $b, $c) -> $L")
						k++ // Increment multiplier to generate next set of triples
					}
				}
			}
		}
		return arr.count { it == 1 }
	}

	//Primitive Triples version - (3, 4, 5) -> 12 is such a triple but (6, 8, 10) -> 24 is not
	fun generatePythagoreanTriples2(limit: Int): Int {
		var arr = IntArray(1_500_001){ 0 }
		// Euclid's formula for generating Pythagorean triples
		for (m in 2..Math.sqrt(limit / 2.0).toInt()) {
			for (n in 1 until m) {
				if ((m - n) % 2 == 1 && gcd(m, n) == 1) {
					val a = m*m - n*n
					val b = 2*m*n
					val c = m*m + n*n
					if (a + b + c <= limit) {
						val L = a+b+c
						arr[L]++
//						println("($a, $b, $c) -> $L")
					} else {
						break // Further values of n will only increase a + b + c
					}
				}
			}
		}
		return arr.count { it == 1 }
	}

	override fun solve(): Any {
		return generatePythagoreanTriples(1_500_000)
	}

}