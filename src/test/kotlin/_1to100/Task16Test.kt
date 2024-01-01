package _1to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to100.Task16

class Task16Test {

	@Test
	fun solve() {
		assertEquals(1366, Task16().solve())
		assertEquals(1366, _1to50.JTask16().solve())
	}
}