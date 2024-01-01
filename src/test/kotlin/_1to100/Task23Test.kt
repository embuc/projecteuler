package _1to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to100.Task23

// Non-Abundant Sums
class Task23Test {

	@Test
	fun solve() {
		assertEquals(4179871, Task23().solve())
		assertEquals(4179871, _1to50.JTask23().solve())
	}
}