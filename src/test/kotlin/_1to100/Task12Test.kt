package _1to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to100.Task12

class Task12Test {

	@Test
	fun solve() {
		assertEquals(76576500L, Task12().solve())
		assertEquals(76576500L, _1to50.JTask12().solve())
	}
}