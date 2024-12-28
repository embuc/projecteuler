package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task99

class Task99Test {

	@Test
	fun solve() {
		assertEquals(709, Task99().solve())
		assertEquals(709, JTask99().solve())
	}
}