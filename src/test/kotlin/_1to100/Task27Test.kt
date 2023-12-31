package _1to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to100.Task27

class Task27Test {

	@Test
	fun solve() {
		assertEquals(-1, Task27().solve())
		assertEquals(-1, JTask27().solve())
	}
}