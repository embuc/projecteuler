package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task73

class Task73Test {

	@Test
	fun solve() {
		assertEquals(7295372, Task73().solve())
		assertEquals(7295372, JTask73().solve())
	}
}