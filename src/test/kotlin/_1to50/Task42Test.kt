package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task42

class Task42Test {

	@Test
	fun solve() {
		assertEquals(162, Task42().solve())
		assertEquals(162L, JTask42().solve())
	}
}