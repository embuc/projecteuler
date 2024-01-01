package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task9

class Task9Test {

	@Test
	fun solve() {
		assertEquals(31875000, Task9().solve())
		assertEquals(31875000, _1to50.JTask9().solve())
	}
}