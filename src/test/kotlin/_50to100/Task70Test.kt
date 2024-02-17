package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task70

class Task70Test {
	@Test
	fun solve() {
		assertEquals(8319823, JTask70().solve())
		assertEquals(8319823, Task70().solve())
	}
}