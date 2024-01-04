package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task35

class Task35Test {
	@Test
	fun solve() {
		assertEquals(55, Task35().solve())
		assertEquals(55, JTask35().solve())
	}
}