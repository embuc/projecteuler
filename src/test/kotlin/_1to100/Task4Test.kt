package _1to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to100.Task4

class Task4Test {

	@Test
	fun solve() {
		assertEquals(906609, Task4().solve());
		assertEquals(906609, _1to50.JTask4().solve());
	}
}