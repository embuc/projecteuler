package _1to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to100.Task17

class Task17Test {

	@Test
	fun solve() {
		assertEquals(21124, Task17().solve())
		assertEquals(21124, JTask17().solve())
	}
}