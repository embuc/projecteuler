package _1to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to100.Task3

class Task3Test {

	@Test
	fun solve() {
		val input = 600851475143L
		assertEquals(6857L, Task3(input).solve())
		assertEquals(6857L, JTask3(input).solve())
	}
}