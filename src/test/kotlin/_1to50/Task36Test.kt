package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task36

class Task36Test {

	@Test
	fun solve() {
		assertEquals(872187, Task36().solve())
		assertEquals(872187, JTask36().solve())
	}
}