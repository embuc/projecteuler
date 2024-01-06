package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task46

class Task46Test {

	@Test
	fun solve() {
		assertEquals(5777, Task46().solve())
		assertEquals(5777, JTask46().solve())
	}
}