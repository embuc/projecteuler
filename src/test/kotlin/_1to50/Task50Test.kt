package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task50

class Task50Test {

	@Test
	fun solve() {
		assertEquals(997651, Task50().solve())
		assertEquals(997651, JTask50().solve())
	}
}