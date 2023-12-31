package _1to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to100.Task27

class Task27Test {

	@Test
	fun solve() {
		assertEquals(-59231L, Task27().solve())
		assertEquals(-59231L, JTask27().solve())
	}
}