package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task2

class Task2Test {

	@Test
	fun solve() {
		assertEquals(4613732, Task2().solve())
		assertEquals(4613732, _1to50.JTask2().solve())
	}
}