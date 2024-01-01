package _1to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to100.Task19

class Task19Test {

	@Test
	fun solve() {
		assertEquals(171, Task19().solve())
		assertEquals(171, _1to50.JTask19().solve())
	}
}