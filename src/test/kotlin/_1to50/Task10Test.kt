package _1to50

import _1to50.JTask10
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task10

class Task10Test {

	@Test
	fun solve() {
		assertEquals(142913828922, Task10().solve())
		assertEquals(142913828922, JTask10().solve())
	}
}