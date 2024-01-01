package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task30

class Task30Test {

	@Test
	fun solve() {
		assertEquals(443839, Task30().solve())
		assertEquals(443839, JTask30().solve())
	}
}