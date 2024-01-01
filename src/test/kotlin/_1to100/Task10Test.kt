package _1to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to100.Task10

class Task10Test {

	@Test
	fun solve() {
		assertEquals(142913828922, Task10().solve())
		assertEquals(142913828922, _1to50.JTask10().solve())
	}
}