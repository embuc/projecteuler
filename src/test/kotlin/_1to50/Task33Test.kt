package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task33

class Task33Test {
	@Test
	fun solve() {
		assertEquals(100L, Task33().solve())
		assertEquals(100L, JTask33().solve())
	}
}