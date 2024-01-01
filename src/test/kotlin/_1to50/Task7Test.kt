package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task7

class Task7Test {

	@Test
	fun solve() {
		assertEquals(104743L, Task7().solve())
		assertEquals(104743L, _1to50.JTask7().solve())
	}
}