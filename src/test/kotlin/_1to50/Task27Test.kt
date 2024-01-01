package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task27

class Task27Test {

	@Test
	fun solve() {
		assertEquals(-59231L, Task27().solve())
		assertEquals(-59231L, _1to50.JTask27().solve())
	}
}