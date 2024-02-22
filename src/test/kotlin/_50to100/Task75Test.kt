package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task75

class Task75Test {

	@Test
	fun solve() {
		assertEquals(161667, Task75().solve())
		assertEquals(161667, JTask75().solve())
	}
}