package _1to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to100.Task20

class Task20Test {

	@Test
	fun solve() {
		assertEquals(648, Task20(100).solve())
		assertEquals(648, JTask20(100).solve())
	}

	@Test
	fun solveExample() {
		assertEquals(27, Task20(10).solve())
		assertEquals(27, JTask20(10).solve())
	}
}