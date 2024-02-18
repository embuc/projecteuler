package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task71

class Task71Test {

	@Test
	fun solve() {
		assertEquals(428570, Task71().solve())
		assertEquals(428570, JTask71().solve())
	}
}