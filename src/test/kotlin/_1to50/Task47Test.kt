package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task47

class Task47Test {

	@Test
	fun solve() {
		assertEquals(134043, Task47().solve())
		assertEquals(134043, JTask47().solve())
	}
}