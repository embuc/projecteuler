package _1to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to100.Task2

class Task2Test {

	@Test
	fun solve() {
		assertEquals(4613732, Task2().solve())
		assertEquals(4613732, JTask2().solve())
	}
}