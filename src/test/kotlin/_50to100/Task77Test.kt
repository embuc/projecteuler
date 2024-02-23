package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task77

class Task77Test {

	@Test
	fun solve() {
		assertEquals(71, Task77().solve())
		assertEquals(71, JTask77().solve())
	}
}