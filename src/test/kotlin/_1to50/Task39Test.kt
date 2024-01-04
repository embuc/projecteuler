package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task39

class Task39Test {

	@Test
	fun solve() {
		assertEquals(840, Task39().solve())
		assertEquals(840, JTask39().solve())
	}
}