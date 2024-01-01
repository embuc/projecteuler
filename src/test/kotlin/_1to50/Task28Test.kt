package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task28

class Task28Test {

	@Test
	fun solve() {
		assertEquals(669171001L, Task28().solve())
		assertEquals(669171001L, _1to50.JTask28().solve())
	}
}