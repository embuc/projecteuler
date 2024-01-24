package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task62

class Task62Test {

	@Test
	fun solve() {
		assertEquals(127_035_954_683, Task62().solve())
		assertEquals(127_035_954_683, JTask62().solve())
	}
}